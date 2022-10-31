package com.portafolio.carlosmarcano.repository;

import com.portafolio.carlosmarcano.models.SoftSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioSoft extends JpaRepository<SoftSkill, Integer> {
    Optional<SoftSkill> findByNombre(String nombreSoft);
    boolean existsByNombre(String nombreSoft);
}
