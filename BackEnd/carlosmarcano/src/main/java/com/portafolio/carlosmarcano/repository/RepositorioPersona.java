package com.portafolio.carlosmarcano.repository;

import com.portafolio.carlosmarcano.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPersona extends JpaRepository<Persona, Long> {
}
