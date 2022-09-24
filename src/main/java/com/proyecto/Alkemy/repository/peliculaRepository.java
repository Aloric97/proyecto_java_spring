package com.proyecto.Alkemy.repository;

import com.proyecto.Alkemy.models.pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface peliculaRepository extends JpaRepository<pelicula, Long> {




    //Deberá mostrar solamente los campos imagen, título y fecha de creación.
    @Query(value="SELECT p.imagen, p.titulo, p.fecha_creacion FROM pelicula p", nativeQuery = true)
    List<pelicula.peliculaProjection> getPeliculas();
    
}
