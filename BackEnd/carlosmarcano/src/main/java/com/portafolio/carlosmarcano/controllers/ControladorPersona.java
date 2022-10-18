package com.portafolio.carlosmarcano.controllers;

import com.portafolio.carlosmarcano.models.Persona;
import com.portafolio.carlosmarcano.services.ServicioPersona;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personas")
@AllArgsConstructor
public class ControladorPersona {

    private final ServicioPersona servicioPersona;
    @PostMapping
    public ResponseEntity guardarPersona(@RequestBody Persona persona){
        return new ResponseEntity(servicioPersona.guardarPersona(persona), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity obtenerPersona(@PathVariable("id") Long idPersona) {
        return new ResponseEntity(servicioPersona.obtenerPersona(idPersona), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity modificarPersona(@PathVariable("id") Long idPersona, @RequestBody Persona persona) {
        return new ResponseEntity(servicioPersona.modificarPersona(idPersona,persona), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPersona(@PathVariable("id") Long idPersona) {
        boolean respuesta = servicioPersona.eliminarPersona(idPersona);
        if (respuesta == true){
            return new ResponseEntity(HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
