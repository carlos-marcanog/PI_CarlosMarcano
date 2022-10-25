package com.portafolio.carlosmarcano.auth.service;

import com.portafolio.carlosmarcano.auth.model.Usuario;
import com.portafolio.carlosmarcano.auth.repository.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ServicioUsuario {

    @Autowired
    RepositorioUsuario repositorioUsuario;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return repositorioUsuario.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario){
        return repositorioUsuario.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email){
        return repositorioUsuario.existsByEmail(email);
    }

    public void guardarUsuario(Usuario usuario){
        repositorioUsuario.save(usuario);
    }
}
