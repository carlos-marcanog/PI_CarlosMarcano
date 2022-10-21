package com.portafolio.carlosmarcano.services;

import com.portafolio.carlosmarcano.models.Persona;
import com.portafolio.carlosmarcano.repository.RepositorioPersona;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicioPersonaImp implements ServicioPersona{
    private final RepositorioPersona repositorioPersona;

    @Override
    public List<Persona> listarPersonas() {
        List<Persona> persona = repositorioPersona.findAll();
        return persona;
    }

    @Override
    public Persona traerPersona(Persona persona) {
        return null;
    }


    @Override
    public Persona guardarPersona(Persona persona) {
        return repositorioPersona.save(persona);
    }

    @Override
    public Persona obtenerPersona(Long idPersona) {
        return repositorioPersona.findById(idPersona).orElse(null);
    }

    @Override
    public Persona modificarPersona(Long id, Persona personaAModificar) {
        Persona personaBuscada = repositorioPersona.findById(id).get();
        personaBuscada.setNombre(personaAModificar.getNombre());
        personaBuscada.setApellido(personaAModificar.getApellido());
        personaBuscada.setTelefono(personaAModificar.getTelefono());
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
