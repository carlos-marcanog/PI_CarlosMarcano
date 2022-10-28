package com.portafolio.carlosmarcano.security.service;

import com.portafolio.carlosmarcano.security.entity.Rol;
import com.portafolio.carlosmarcano.security.repository.RolRepositorio;
import com.portafolio.carlosmarcano.security.enums.RolNombre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolServicio {

    @Autowired
    RolRepositorio rolRepositorio;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepositorio.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        rolRepositorio.save(rol);
    }

}