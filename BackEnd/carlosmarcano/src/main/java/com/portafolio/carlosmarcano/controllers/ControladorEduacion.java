package com.portafolio.carlosmarcano.controllers;

import org.apache.commons.lang3.StringUtils;
import com.portafolio.carlosmarcano.dto.DtoEducacion;
import com.portafolio.carlosmarcano.models.Educacion;
import com.portafolio.carlosmarcano.security.controller.Mensaje;
import com.portafolio.carlosmarcano.services.ServicioEduacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("educacion")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ControladorEduacion {

    @Autowired
    ServicioEduacion servicioEduacion;

    @GetMapping("/list")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = servicioEduacion.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if (!servicioEduacion.existsById(id)){
            return new ResponseEntity(new Mensaje("ID No Existe"),HttpStatus.NOT_FOUND);
        }
        Educacion educacion = servicioEduacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if (!servicioEduacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("No Existe el ID"), HttpStatus.NOT_FOUND);
        }
        servicioEduacion.delete(id);
        return new ResponseEntity(new Mensaje("Eduacion Eliminada"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> crear(@RequestBody DtoEducacion dtoEducacion){
        if (StringUtils.isBlank(dtoEducacion.getNombreEdu())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (servicioEduacion.existsByNombreEdu(dtoEducacion.getNombreEdu())){
            return new ResponseEntity(new Mensaje("El nombre ingresado ya Existe"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = new Educacion(
                dtoEducacion.getNombreEdu(),
                dtoEducacion.getUbicacion(),
                dtoEducacion.getTitulo(),
                dtoEducacion.getAnioEgreso() );
        servicioEduacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion Creada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEducacion){
        if (!servicioEduacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (servicioEduacion.existsByNombreEdu(dtoEducacion.getNombreEdu())
                && servicioEduacion.getByNombreEdu(dtoEducacion.getNombreEdu()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Educacion ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoEducacion.getNombreEdu())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = servicioEduacion.getOne(id).get();
        educacion.setNombreEdu(dtoEducacion.getNombreEdu());
        educacion.setUbicacion(dtoEducacion.getUbicacion());
        educacion.setTitulo(dtoEducacion.getTitulo());
        educacion.setAnioEgreso(dtoEducacion.getAnioEgreso());
        servicioEduacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion Actualizada"), HttpStatus.OK);
    }
}
