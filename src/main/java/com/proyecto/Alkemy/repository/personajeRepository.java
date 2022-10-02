package com.proyecto.Alkemy.repository;


import com.proyecto.Alkemy.models.personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface personajeRepository extends JpaRepository<personaje, Long> {


    //Consulta para obtener todos los personajes
    List<personaje> findAll();

    //Consulta para obtener todos los personajes con el mismo nombre
    List<personaje> findByNombre(String nombre);


    //consulta para buscar un personaje por id
    personaje findById(long id);

    //Comprueba si existe un personaje por id
    boolean existsById(long id);

    //Crear un personaje
    personaje save(personaje personaje);

    //Borrar un personaje
    String deleteById(long id);

    //Borrar todos los personajes
    void deleteAll();




}
