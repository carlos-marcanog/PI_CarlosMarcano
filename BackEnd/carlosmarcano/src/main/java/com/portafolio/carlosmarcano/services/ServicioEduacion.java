package com.portafolio.carlosmarcano.services;

import com.portafolio.carlosmarcano.models.Educacion;
import com.portafolio.carlosmarcano.repository.RepositorioEduacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServicioEduacion {
    @Autowired
    RepositorioEduacion repositorioEduacion;

    public List<Educacion> list(){
        return repositorioEduacion.findAll();
    }

    public Optional<Educacion> getOne(int id){
        return repositorioEduacion.findById(id);
    }

    public Optional<Educacion> getByNombreEdu(String nombreEdu){
        return repositorioEduacion.findByNombreEdu(nombreEdu);
    }

    public void save(Educacion educacion){
        repositorioEduacion.save(educacion);
    }

    public void delete(int id){
        repositorioEduacion.deleteById(id);
    }

    public boolean existsById(int id){
        return repositorioEduacion.existsById(id);
    }

    public boolean existsByNombreEdu(String nombreEdu){
        return repositorioEduacion.existsByNombreEdu(nombreEdu);
    }
}
