package com.portafolio.carlosmarcano.repository;

import com.portafolio.carlosmarcano.models.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioSkills extends JpaRepository<Skills, Integer> {
    Optional<Skills> findByNombre(String nombreSkill);
    boolean existsByNombre(String nombreSkill);
}
