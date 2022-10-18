package com.portafolio.carlosmarcano.services;

import com.portafolio.carlosmarcano.models.Persona;

public interface ServicioPersona {
    Persona guardarPersona(Persona persona);

    Persona obtenerPersona(Long idPersona);

    Persona modificarPersona(Long id, Persona personaAModificar);

    boolean eliminarPersona(Long id);
}

