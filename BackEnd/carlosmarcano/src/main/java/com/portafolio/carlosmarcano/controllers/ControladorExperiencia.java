package com.portafolio.carlosmarcano.controllers;

import com.portafolio.carlosmarcano.dto.DtoExperiencia;
import com.portafolio.carlosmarcano.models.Experiencia;
import com.portafolio.carlosmarcano.security.controller.Mensaje;
import com.portafolio.carlosmarcano.services.ServicioExperiencia;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("experiencia")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ControladorExperiencia {

    @Autowired
    ServicioExperiencia servicioExperiencia;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = servicioExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoExperiencia){
        if(StringUtils.isBlank(dtoExperiencia.getNombreExp())){
            return new ResponseEntity(new Mensaje("El Nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (servicioExperiencia.existsByNombreExp(dtoExperiencia.getNombreExp())){
            return new ResponseEntity(new Mensaje("Esa Experiencia ya Existe"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = new Experiencia(dtoExperiencia.getNombreExp(), dtoExperiencia.getDescripcionExp(),
                                                  dtoExperiencia.getCargo(), dtoExperiencia.getFechaIngreso(),
                                                  dtoExperiencia.getFechaEgreso());
        servicioExperiencia.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia Agregada"), HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoExperiencia){
        if (!servicioExperiencia.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }
        if (servicioExperiencia.existsByNombreExp(dtoExperiencia.getNombreExp())&& servicioExperiencia
                .getByNombreExp(dtoExperiencia.getNombreExp()).get().getId() !=id){
            return new ResponseEntity(new Mensaje("Esa Experiencia ya Existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoExperiencia.getNombreExp())){
            return new ResponseEntity(new Mensaje("El Nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = servicioExperiencia.getOne(id).get();
        experiencia.setNombreExp(dtoExperiencia.getNombreExp());
        experiencia.setDescripcionExp(dtoExperiencia.getDescripcionExp());
        experiencia.setCargo(dtoExperiencia.getCargo());
        experiencia.setFechaIngreso(dtoExperiencia.getFechaIngreso());
        experiencia.setFechaEgreso(dtoExperiencia.getFechaEgreso());

        servicioExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia Actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if (servicioExperiencia.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID No Existe"), HttpStatus.BAD_REQUEST);
        }
        servicioExperiencia.delete(id);

        return new ResponseEntity(new Mensaje("Experiencia Eliminada"), HttpStatus.OK);
    }
}
