package com.portafolio.carlosmarcano.services;

import com.portafolio.carlosmarcano.models.Persona;

import java.util.List;

public interface ServicioPersona {

    List<Persona> listarPersonas();

    Persona traerPersona(Persona persona);

    Persona guardarPersona(Persona persona);

    Persona obtenerPersona(Long id);

    Persona modificarPersona(Long id, Persona personaAModificar);

    boolean eliminarPersona(Long id);

}

