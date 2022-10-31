package com.portafolio.carlosmarcano.controllers;

import com.portafolio.carlosmarcano.dto.DtoProyectos;
import com.portafolio.carlosmarcano.models.Proyectos;
import com.portafolio.carlosmarcano.security.controller.Mensaje;
import com.portafolio.carlosmarcano.services.ServicioProyectos;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("proyectos")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ControladorProyectos {

    @Autowired
    ServicioProyectos servicioProyectos;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = servicioProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity obtenerProyecto(@PathVariable("id") int id) {
        return new ResponseEntity(servicioProyectos.getOne(id), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoProyectos dtoProyectos){
        if(StringUtils.isBlank(dtoProyectos.getNombre())){
            return new ResponseEntity(new Mensaje("El Nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (servicioProyectos.existsByNombre(dtoProyectos.getNombre())){
            return new ResponseEntity(new Mensaje("Ese Proyecto ya Existe"), HttpStatus.BAD_REQUEST);
        }
        Proyectos proyectos = new Proyectos(dtoProyectos.getNombre(), dtoProyectos.getDescripcion(),
                dtoProyectos.getEnlace(), dtoProyectos.getImg());
        servicioProyectos.save(proyectos);

        return new ResponseEntity(new Mensaje("Proyecto Agregado"), HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyectos dtoProyectos){
        if (!servicioProyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }
        if (servicioProyectos.existsByNombre(dtoProyectos.getNombre())&& servicioProyectos
                .getByNombre(dtoProyectos.getNombre()).get().getId() !=id){
            return new ResponseEntity(new Mensaje("Ese Proyecto ya Existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoProyectos.getNombre())){
            return new ResponseEntity(new Mensaje("El Nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoProyectos.getDescripcion())){
            return new ResponseEntity(new Mensaje("La Descripcion es Obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoProyectos.getEnlace())){
            return new ResponseEntity(new Mensaje("El Enlace es Obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyectos = servicioProyectos.getOne(id).get();
        proyectos.setNombre(dtoProyectos.getNombre());
        proyectos.setDescripcion(dtoProyectos.getDescripcion());
        proyectos.setEnlace(dtoProyectos.getEnlace());
        proyectos.setImg(dtoProyectos.getImg());

        servicioProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto Actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        servicioProyectos.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto Eliminado"), HttpStatus.OK);
    }
}
