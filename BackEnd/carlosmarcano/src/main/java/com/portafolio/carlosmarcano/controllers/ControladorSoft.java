package com.portafolio.carlosmarcano.controllers;

import com.portafolio.carlosmarcano.dto.DtoSkills;
import com.portafolio.carlosmarcano.models.Experiencia;
import com.portafolio.carlosmarcano.models.Skills;
import com.portafolio.carlosmarcano.models.SoftSkill;
import com.portafolio.carlosmarcano.security.controller.Mensaje;
import com.portafolio.carlosmarcano.services.ServicioSoft;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("softs")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ControladorSoft {

    @Autowired
    ServicioSoft servicioSoft;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<SoftSkill> list = servicioSoft.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity obtenerSoft(@PathVariable("id") int id) {
        return new ResponseEntity(servicioSoft.getOne(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createSoft(@RequestBody DtoSkills dtoSkills){
        if(StringUtils.isBlank(dtoSkills.getNombre())){
            return new ResponseEntity(new Mensaje("El Nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (servicioSoft.existsByNombre(dtoSkills.getNombre())){
            return new ResponseEntity(new Mensaje("Esa Skill ya Existe"), HttpStatus.BAD_REQUEST);
        }
        SoftSkill softSkill = new SoftSkill(dtoSkills.getNombre(), dtoSkills.getPorcentaje());
        servicioSoft.save(softSkill);

        return new ResponseEntity(new Mensaje("Skill Agregada"), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateSoft(@PathVariable("id") int id, @RequestBody DtoSkills dtoSkills){
        if (!servicioSoft.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }
        if (servicioSoft.existsByNombre(dtoSkills.getNombre())&& servicioSoft
                .getByNombre(dtoSkills.getNombre()).get().getId() !=id){
            return new ResponseEntity(new Mensaje("Esa Skill ya Existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoSkills.getNombre())){
            return new ResponseEntity(new Mensaje("El Nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }

        SoftSkill softSkill = servicioSoft.getOne(id).get();
        softSkill.setNombre(dtoSkills.getNombre());
        softSkill.setPorcentaje(dtoSkills.getPorcentaje());

        servicioSoft.save(softSkill);
        return new ResponseEntity(new Mensaje("Experiencia Actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSoft(@PathVariable("id") int id){

        servicioSoft.delete(id);

        return new ResponseEntity(new Mensaje("Experiencia Eliminada"), HttpStatus.OK);
    }

}
