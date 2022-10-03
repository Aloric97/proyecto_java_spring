package com.proyecto.Alkemy.service;


import com.proyecto.Alkemy.models.personaje;
import com.proyecto.Alkemy.repository.personajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface personajeService {


    //Metodo para obtener todos los personajes
    public List<personaje> getAllPersonajes();

    //Metodo para obtener todos los personajes por nombre
    public List<personaje> getPersonajeByNombre(String nombre);


    //Metodo para buscar un personaje por id
    public personaje getPersonajeById(long id);

    // metodos para saber si existe un personaje por id
    public boolean existsById(long id);

    //Metodo para crear un personaje
    public personaje save(personaje personaje);

    //Metodo para borrar un personaje
    public String deleteById(long id);

    //Metodo para borrar todos los personajes
    public void deleteAll();

    // lista de personajes por nombre e imagen
    public List<personaje.personajeProjection> selectByNombreAndImagen();

}
