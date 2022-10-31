package com.portafolio.carlosmarcano.services;

import com.portafolio.carlosmarcano.models.Proyectos;
import com.portafolio.carlosmarcano.repository.RepositorioProyectos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServicioProyectos {

    @Autowired
    RepositorioProyectos repositorioProyectos;

    public List<Proyectos> list(){
        return repositorioProyectos.findAll();
    }

    public Optional<Proyectos> getOne(int id){
        return repositorioProyectos.findById(id);
    }

    public Optional<Proyectos> getByNombre(String nombre){
        return repositorioProyectos.findByNombre(nombre);
    }

    public void save(Proyectos proyectos){
        repositorioProyectos.save(proyectos);
    }

    public void delete(int id){
        repositorioProyectos.deleteById(id);
    }

    public boolean existsById(int id){
        return repositorioProyectos.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return repositorioProyectos.existsByNombre(nombre);
    }
}
