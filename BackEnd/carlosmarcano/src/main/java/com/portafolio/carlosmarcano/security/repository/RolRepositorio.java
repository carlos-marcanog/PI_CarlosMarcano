package com.portafolio.carlosmarcano.security.repository;

import com.portafolio.carlosmarcano.security.entity.Rol;
import com.portafolio.carlosmarcano.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepositorio extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
