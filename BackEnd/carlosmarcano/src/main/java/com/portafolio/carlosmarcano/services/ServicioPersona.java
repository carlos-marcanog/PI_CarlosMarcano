package com.portafolio.carlosmarcano.services;

import com.portafolio.carlosmarcano.models.Persona;
import com.portafolio.carlosmarcano.repository.RepositorioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServicioPersona {
    @Autowired
    RepositorioPersona repositorioPersona;

    public List<Persona> list(){
        return repositorioPersona.findAll();
    }

    public Optional<Persona> getOne(int id){
        return repositorioPersona.findById(id);
    }

    public Optional<Persona> getByNombre(String nombre){
        return repositorioPersona.findByNombre(nombre);
    }

    public void save(Persona persona){
        repositorioPersona.save(persona);
    }

    public void delete(int id){
        repositorioPersona.deleteById(id);
    }

    public boolean existsById(int id){
        return repositorioPersona.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return repositorioPersona.existsByNombre(nombre);
    }

}
