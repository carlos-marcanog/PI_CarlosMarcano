package com.portafolio.carlosmarcano.repository;

import com.portafolio.carlosmarcano.models.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioEduacion extends JpaRepository<Educacion, Integer> {
    Optional<Educacion> findByNombreEdu(String nombreEdu);
    boolean existsByNombreEdu(String nombreEdu);
}
