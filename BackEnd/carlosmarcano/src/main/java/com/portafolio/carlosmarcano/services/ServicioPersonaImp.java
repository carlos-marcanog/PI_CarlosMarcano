package com.portafolio.carlosmarcano.services;

import com.portafolio.carlosmarcano.models.Persona;
import com.portafolio.carlosmarcano.repository.RepositorioPersona;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class ServicioPersonaImp implements ServicioPersona{
    private final RepositorioPersona repositorioPersona;

    @Override
    public Persona guardarPersona(Persona persona) {
        return repositorioPersona.save(persona);
    }

    @Override
    public Persona obtenerPersona(Long idPersona) {
        return repositorioPersona.findById(idPersona).orElseThrow(()-> {throw new RuntimeException();});
    }

    @Override
    public Persona modificarPersona(Long id, Persona personaAModificar) {
        Persona personaBuscada = repositorioPersona.findById(id).get();
        personaBuscada.setDireccion(personaAModificar.getNombre());
        personaBuscada.setDireccion(personaAModificar.getApellido());
        personaBuscada.setDireccion(personaAModificar.getTelefono());
        personaBuscada.setDireccion(personaAModificar.getDireccion());
        return repositorioPersona.save(personaBuscada);
    }

    @Override
    public boolean eliminarPersona(Long id) {
        try{
            repositorioPersona.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
