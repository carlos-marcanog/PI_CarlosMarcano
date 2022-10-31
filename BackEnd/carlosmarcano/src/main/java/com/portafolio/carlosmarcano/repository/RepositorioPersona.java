package com.portafolio.carlosmarcano.repository;

import com.portafolio.carlosmarcano.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioPersona extends JpaRepository<Persona, Integer> {
    Optional<Persona> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
