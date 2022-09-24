package com.proyecto.Alkemy.repository;


import com.proyecto.Alkemy.models.personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface personajeRepository extends JpaRepository<personaje, Long> {


    //Consulta para obtener todos los personajes
    List<personaje> findAll();

    //Consulta para obtener todos los personajes por nombre
    List<personaje> findByNombre(String nombre);

    //Consulta para buscar un nombre que sea igual al nombre que se le pasa por parametro
    List<personaje> findByNombreContaining(String nombre);



}
