package com.proyecto.Alkemy.service;

import com.proyecto.Alkemy.models.personaje;
import com.proyecto.Alkemy.repository.personajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class personajeServiceImp implements personajeService {

    @Autowired
    private personajeRepository personajeRepository;


    @Override
    public List<personaje> getAllPersonajes() {
        return personajeRepository.findAll();
    }

    @Override
    public List<personaje> getPersonajeByNombre(String nombre) {
        return personajeRepository.findByNombre(nombre);
    }


    @Override
    public personaje getPersonajeById(long id) {
        return personajeRepository.findById(id);
    }

    @Override
    public boolean existsById(long id) {
        return personajeRepository.existsById(id);
    }

    @Override
    public personaje save(personaje personaje) {
        if (personaje != null) {
            return personajeRepository.save(personaje);
        }
        return null;
    }

    @Override
    public String deleteById(long id) {
        if(existsById(id)){
            personajeRepository.deleteById(id);
            return "Personaje eliminado";
        }
        return "No se pudo eliminar el personaje";
    }

    @Override
    public void deleteAll() {
        personajeRepository.deleteAll();
    }


}