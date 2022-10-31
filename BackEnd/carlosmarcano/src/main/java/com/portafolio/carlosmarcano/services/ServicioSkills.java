package com.portafolio.carlosmarcano.services;

import com.portafolio.carlosmarcano.models.Skills;
import com.portafolio.carlosmarcano.repository.RepositorioSkills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServicioSkills {
    @Autowired
    RepositorioSkills repositorioSkills;

    public List<Skills> list(){
        return repositorioSkills.findAll();
    }

    public Optional<Skills> getOne(int id){
        return repositorioSkills.findById(id);
    }

    public Optional<Skills> getByNombre(String nombreSkill){
        return repositorioSkills.findByNombre(nombreSkill);
    }

    public void save(Skills skills){
        repositorioSkills.save(skills);
    }

    public void delete(int id){
        repositorioSkills.deleteById(id);
    }

    public boolean existsById(int id){
        return repositorioSkills.existsById(id);
    }

    public boolean existsByNombre(String nombreSkill){
        return repositorioSkills.existsByNombre(nombreSkill);
    }
}
