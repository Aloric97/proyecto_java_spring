package com.proyecto.Alkemy.service;


import com.proyecto.Alkemy.models.personaje;
import com.proyecto.Alkemy.repository.personajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class personajeService {

    @Autowired
    private com.proyecto.Alkemy.repository.personajeRepository personajeRepository;

    //Metodo para obtener todos los personajes
    public List<personaje> getAllPersonajes(){
        return personajeRepository.findAll();
    }

    //Metodo para obtener todos los personajes por nombre
    public List<personaje> getPersonajeByNombre(String nombre){
        return personajeRepository.findByNombre(nombre);
    }

    //Metodo para obtener todos los personajes por nombre que contenga el nombre que se le pasa por parametro

    public List<personaje> getPersonajeByNombreContaining(String nombre){
        return personajeRepository.findByNombreContaining(nombre);
    }

    //Metodo para buscar un personaje por id
    public personaje getPersonajeById(long id){
        return personajeRepository.findById(id);
    }

    // metodos para saber si existe un personaje por id
    public boolean existsById(long id){
        return personajeRepository.existsById(id);
    }

    //Metodo para crear un personaje
    public personaje save(personaje personaje){
        return personajeRepository.save(personaje);
    }

    //Metodo para borrar un personaje
    public void deleteById(long id){
        personajeRepository.deleteById(id);
    }

    //Metodo para borrar todos los personajes
    public void deleteAll(){
        personajeRepository.deleteAll();
    }

    //Metodo para actualizar un personaje
    public personaje update(personaje personaje){
        return personajeRepository.save(personaje);
    }


}
