package com.proyecto.Alkemy.service;


import com.proyecto.Alkemy.models.pelicula;
import com.proyecto.Alkemy.repository.peliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class peliculaService {

    @Autowired
    private peliculaRepository peliculaRepository;

    //Deberá mostrar solamente los campos imagen, título y fecha de creación.
    public List<pelicula.peliculaProjection> getAllPeliculas(){
        return peliculaRepository.getPeliculas();
    }
}
