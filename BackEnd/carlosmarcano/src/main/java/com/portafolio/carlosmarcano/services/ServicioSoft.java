package com.portafolio.carlosmarcano.services;

import com.portafolio.carlosmarcano.models.SoftSkill;
import com.portafolio.carlosmarcano.repository.RepositorioSoft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServicioSoft {
    @Autowired
    RepositorioSoft repositorioSoft;

    public List<SoftSkill> list(){
        return repositorioSoft.findAll();
    }

    public Optional<SoftSkill> getOne(int id){
        return repositorioSoft.findById(id);
    }

    public Optional<SoftSkill> getByNombre(String nombreSoft){
        return repositorioSoft.findByNombre(nombreSoft);
    }

    public void save(SoftSkill softSkill){
        repositorioSoft.save(softSkill);
    }

    public void delete(int id){
        repositorioSoft.deleteById(id);
    }

    public boolean existsById(int id){
        return repositorioSoft.existsById(id);
    }

    public boolean existsByNombre(String nombreSoft){
        return repositorioSoft.existsByNombre(nombreSoft);
    }
}
