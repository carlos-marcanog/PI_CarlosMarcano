package com.portafolio.carlosmarcano.controllers;

import com.portafolio.carlosmarcano.dto.DtoPersona;
import com.portafolio.carlosmarcano.models.Persona;
import com.portafolio.carlosmarcano.security.controller.Mensaje;
import com.portafolio.carlosmarcano.services.ServicioPersona;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("personas")
@CrossOrigin(origins = {"http://localhost:4200", "https://portfolio-fend.web.app/"})

public class ControladorPersona {

    @Autowired
    ServicioPersona servicioPersona;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = servicioPersona.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if (!servicioPersona.existsById(id)){
            return new ResponseEntity(new Mensaje("ID No Existe"),HttpStatus.NOT_FOUND);
        }
        Persona persona = servicioPersona.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtoPersona){
        if (!servicioPersona.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (servicioPersona.existsByNombre(dtoPersona.getNombre())
                && servicioPersona.getByNombre(dtoPersona.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Persona ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoPersona.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = servicioPersona.getOne(id).get();
        persona.setNombre(dtoPersona.getNombre());
        persona.setApellido(dtoPersona.getApellido());
        persona.setCargo(dtoPersona.getCargo());
        persona.setAcercade(dtoPersona.getAcercade());
        persona.setImg(dtoPersona.getImg());
        servicioPersona.save(persona);
        return new ResponseEntity(new Mensaje("Persona Actualizada"), HttpStatus.OK);
    }
}
