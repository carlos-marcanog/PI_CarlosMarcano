/*
 * Copyright (c) 2022.
 */

package com.portafolio.carlosmarcano.repository;

import com.portafolio.carlosmarcano.models.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioExperiencia extends JpaRepository<Experiencia, Integer> {
    Optional<Experiencia> findByNombreExp(String nombreExp);
    boolean existsByNombreExp(String nombreExp);
}
