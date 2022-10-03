package com.proyecto.Alkemy.controllers;

import com.proyecto.Alkemy.dto.Mensaje;
import com.proyecto.Alkemy.models.personaje;
import com.proyecto.Alkemy.service.personajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/characters")
public class personajeController {

    @Autowired
    personajeService personajeService;


    //crear personaje
    @PostMapping("/create")
    ResponseEntity<?> createPersonaje(@RequestBody personaje personaje){

        if(personaje.getNombre().isEmpty()){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if(personaje.getEdad() == 0){
            return new ResponseEntity(new Mensaje("La edad es obligatoria"), HttpStatus.BAD_REQUEST);
        }

        if(personaje.getHistoria().isEmpty()){
            return new ResponseEntity(new Mensaje("La historia es obligatoria"), HttpStatus.BAD_REQUEST);
        }

        if(personaje.getPeso() == 0){
            return new ResponseEntity(new Mensaje("El peso es obligatorio"), HttpStatus.BAD_REQUEST);
        }


        personajeService.save(personaje);
        return new ResponseEntity(new Mensaje("Personaje creado"), HttpStatus.OK);
    }

    //actualizar personaje
    @PatchMapping("/update/{id}")
    ResponseEntity<?> updatePersonaje(@PathVariable("id") long id, @RequestBody personaje personaje){

        if(!personajeService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el personaje"), HttpStatus.NOT_FOUND);
        }

        personaje personaje1 = personajeService.getPersonajeById(id);
        personaje1.setNombre(personaje.getNombre());
        personaje1.setImagen(personaje.getImagen());
        personaje1.setEdad(personaje.getEdad());
        personaje1.setHistoria(personaje.getHistoria());
        personaje1.setPeso(personaje.getPeso());

        personajeService.save(personaje);
        return new ResponseEntity(new Mensaje("Personaje actualizado"), HttpStatus.OK);

    }





    //Eliminar personaje por id
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deletePersonajeById(@PathVariable("id") long id)  {
        if(!personajeService.existsById(id)){
            return new ResponseEntity<>(new Mensaje("No existe el personaje"),HttpStatus.NOT_FOUND);
        }
        personajeService.deleteById(id);
        return new ResponseEntity<>(new Mensaje("Se ha eliminado el personaje:" +id ),HttpStatus.OK);
    }

    //obtener todos los personajes
    @GetMapping("/all")
    ResponseEntity<List<personaje>> getAllPersonajes(){
        return ResponseEntity.ok(personajeService.getAllPersonajes());
    }

    // un personaje por nombre que contenga el nombre que se le pasa por parametro
    @GetMapping(params = "name")
    ResponseEntity<List<personaje>> getPersonajeByNombreContaining(@RequestParam String name){
        if (personajeService.getPersonajeByNombre(name).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(personajeService.getPersonajeByNombre(name));
    }

    // metodo para buscar personaje por id
    @GetMapping("/{id}")
    ResponseEntity<?> getPersonajeById(@PathVariable("id") long id)  {
           if(!personajeService.existsById(id)){
               return new ResponseEntity<>(new Mensaje("El id: " + id +" no existe"),HttpStatus.NOT_FOUND);
           }
              return ResponseEntity.ok(personajeService.getPersonajeById(id));
    }


    //Listar personajes solo por nombre y imagen
    @GetMapping("/nombreImagen")
    ResponseEntity<List<personaje.personajeProjection>> getPersonajeByNombreImagen(){
        return ResponseEntity.ok(personajeService.selectByNombreAndImagen());
    }


}
