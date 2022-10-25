package com.portafolio.carlosmarcano.auth.service;

import com.portafolio.carlosmarcano.auth.model.Admin;
import com.portafolio.carlosmarcano.auth.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImp implements UserDetailsService {

    @Autowired
    ServicioUsuario servicioUsuario;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = servicioUsuario.getByNombreUsuario(nombreUsuario).get();
        return Admin.build(usuario);
    }
}
