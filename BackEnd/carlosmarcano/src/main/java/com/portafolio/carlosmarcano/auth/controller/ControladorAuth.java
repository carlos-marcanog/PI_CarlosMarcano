package com.portafolio.carlosmarcano.auth.controller;

import com.portafolio.carlosmarcano.auth.dto.JwtDto;
import com.portafolio.carlosmarcano.auth.dto.LoginUsuario;
import com.portafolio.carlosmarcano.auth.dto.NuevoUsuario;
import com.portafolio.carlosmarcano.auth.jwt.Provider;
import com.portafolio.carlosmarcano.auth.model.Rol;
import com.portafolio.carlosmarcano.auth.model.Usuario;
import com.portafolio.carlosmarcano.auth.service.ServicioRol;
import com.portafolio.carlosmarcano.auth.service.ServicioUsuario;
import com.portafolio.carlosmarcano.auth.types.RolNombre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class ControladorAuth {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    ServicioUsuario servicioUsuario;

    @Autowired
    ServicioRol servicioRol;

    @Autowired
    Provider provider;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity(new Mensaje("Campos Invalidos"), HttpStatus.BAD_REQUEST);
        }
        if (servicioUsuario.existsByNombreUsuario(nuevoUsuario.getNombreUsuario())){
            return new ResponseEntity(new Mensaje("Nombre de Usuario Existe"), HttpStatus.BAD_REQUEST);
        }
        if (servicioUsuario.existsByEmail(nuevoUsuario.getEmail())){
            return new ResponseEntity(new Mensaje("Email Existe"), HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),
                nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));

        Set<Rol> roles = new HashSet<>();
        roles.add(servicioRol.getByRolNombre(RolNombre.USER_ROLE).get());

        if (nuevoUsuario.getRoles().contains("admin")){
            roles.add(servicioRol.getByRolNombre(RolNombre.ADMIN_ROLE).get());
        }
        usuario.setRoles(roles);
        servicioUsuario.guardarUsuario(usuario);

        return new ResponseEntity<>(new Mensaje("Usuario Guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity(new Mensaje("Campos Invalidos"), HttpStatus.BAD_REQUEST);
        }

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = provider.generarToken(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }

}
