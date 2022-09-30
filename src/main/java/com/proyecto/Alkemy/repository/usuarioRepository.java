package com.proyecto.Alkemy.repository;

import com.proyecto.Alkemy.models.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface usuarioRepository extends JpaRepository<usuario, Long> {

    Optional<usuario> findByNombreUsuario(String NombreUsuario);
    boolean existsByNombreUsuario(String NombreUsuario);
    boolean existsByEmail(String email);

}
