package com.portafolio.carlosmarcano.repository;

import com.portafolio.carlosmarcano.models.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioProyectos extends JpaRepository<Proyectos, Integer> {
    Optional<Proyectos> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
