package com.proyecto.Alkemy.controllers;


import com.proyecto.Alkemy.models.pelicula;
import com.proyecto.Alkemy.service.peliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/films")
public class peliculaController {

    @Autowired
    private peliculaService peliculaService;

    //Deberá mostrar solamente los campos imagen, título y fecha de creación.
    @GetMapping("/all")
    ResponseEntity<List<pelicula.peliculaProjection>> getAllPeliculas(){
        return ResponseEntity.ok(peliculaService.getAllPeliculas());
    }
}
