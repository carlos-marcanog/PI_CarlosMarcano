package com.portafolio.carlosmarcano.services;

import com.portafolio.carlosmarcano.models.Experiencia;
import com.portafolio.carlosmarcano.repository.RepositorioExperiencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServicioExperiencia {

    @Autowired
    RepositorioExperiencia repositorioExperiencia;

    public List<Experiencia> list(){
        return repositorioExperiencia.findAll();
    }

    public Optional<Experiencia> getOne(int id){
        return repositorioExperiencia.findById(id);
    }

    public Optional<Experiencia> getByNombreExp(String nombreExp){
        return repositorioExperiencia.findByNombreExp(nombreExp);
    }

    public void save(Experiencia experiencia){
        repositorioExperiencia.save(experiencia);
    }

    public void delete(int id){
        repositorioExperiencia.deleteById(id);
    }

    public boolean existsById(int id){
        return repositorioExperiencia.existsById(id);
    }

    public boolean existsByNombreExp(String nombreExp){
        return repositorioExperiencia.existsByNombreExp(nombreExp);
    }
}
