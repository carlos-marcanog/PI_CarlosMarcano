package com.portafolio.carlosmarcano.auth.repository;

import com.portafolio.carlosmarcano.auth.model.Rol;
import com.portafolio.carlosmarcano.auth.types.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioRol extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
