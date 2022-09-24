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
}
