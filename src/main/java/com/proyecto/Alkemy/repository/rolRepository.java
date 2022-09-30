package com.proyecto.Alkemy.repository;

import com.proyecto.Alkemy.models.rol;
import com.proyecto.Alkemy.models.rolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface rolRepository extends JpaRepository<rol, Long> {
    Optional<rol> findByrolNombre(rolNombre rolNombre);

}
