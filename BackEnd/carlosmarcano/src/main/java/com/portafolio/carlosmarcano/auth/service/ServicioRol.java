package com.portafolio.carlosmarcano.auth.service;

import com.portafolio.carlosmarcano.auth.model.Rol;
import com.portafolio.carlosmarcano.auth.repository.RepositorioRol;
import com.portafolio.carlosmarcano.auth.types.RolNombre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ServicioRol {

    @Autowired
    RepositorioRol repositorioRol;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return repositorioRol.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        repositorioRol.save(rol);
    }

}