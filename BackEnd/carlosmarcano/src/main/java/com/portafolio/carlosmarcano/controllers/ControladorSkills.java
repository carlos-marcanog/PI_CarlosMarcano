package com.portafolio.carlosmarcano.controllers;

import com.portafolio.carlosmarcano.dto.DtoSkills;
import com.portafolio.carlosmarcano.models.Experiencia;
import com.portafolio.carlosmarcano.models.Skills;
import com.portafolio.carlosmarcano.security.controller.Mensaje;
import com.portafolio.carlosmarcano.services.ServicioSkills;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("skills")
@CrossOrigin(origins = {"http://localhost:4200/", "https://portfolio-fend.web.app/"})
public class ControladorSkills {
    @Autowired
    ServicioSkills servicioSkills;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Skills> list = servicioSkills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity obtenerExp(@PathVariable("id") int id) {
        return new ResponseEntity(servicioSkills.getOne(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSkills dtoSkills){
        if(StringUtils.isBlank(dtoSkills.getNombre())){
            return new ResponseEntity(new Mensaje("El Nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (servicioSkills.existsByNombre(dtoSkills.getNombre())){
            return new ResponseEntity(new Mensaje("Esa Skill ya Existe"), HttpStatus.BAD_REQUEST);
        }
        Skills skills = new Skills(dtoSkills.getNombre(), dtoSkills.getPorcentaje());
        servicioSkills.save(skills);

        return new ResponseEntity(new Mensaje("Skill Agregada"), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSkills dtoSkills){
        if (!servicioSkills.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }
        if (servicioSkills.existsByNombre(dtoSkills.getNombre())&& servicioSkills
                .getByNombre(dtoSkills.getNombre()).get().getId() !=id){
            return new ResponseEntity(new Mensaje("Esa Skill ya Existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoSkills.getNombre())){
            return new ResponseEntity(new Mensaje("El Nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Skills skills = servicioSkills.getOne(id).get();
        skills.setNombre(dtoSkills.getNombre());
        skills.setPorcentaje(dtoSkills.getPorcentaje());

        servicioSkills.save(skills);
        return new ResponseEntity(new Mensaje("Experiencia Actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){

        servicioSkills.delete(id);

        return new ResponseEntity(new Mensaje("Experiencia Eliminada"), HttpStatus.OK);
    }
}
