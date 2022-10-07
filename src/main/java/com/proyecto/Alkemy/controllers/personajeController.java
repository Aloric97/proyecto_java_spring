package com.proyecto.Alkemy.controllers;

import com.proyecto.Alkemy.dto.Mensaje;
import com.proyecto.Alkemy.models.personaje;
import com.proyecto.Alkemy.service.personajeService;
import io.swagger.annotations.ApiOperation;
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



    @PostMapping("/create")
    @ApiOperation(value = "Crea un personaje", notes = "Recibe un personaje y lo crea")

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
    @ApiOperation(value = "Actualiza un personaje", notes = "Recibe un personaje y lo actualiza")
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
    @ApiOperation(value = "Elimina un personaje", notes = "Recibe un id y elimina el personaje")
    ResponseEntity<?> deletePersonajeById(@PathVariable("id") long id)  {
        if(!personajeService.existsById(id)){
            return new ResponseEntity<>(new Mensaje("No existe el personaje"),HttpStatus.NOT_FOUND);
        }
        personajeService.deleteById(id);
        return new ResponseEntity<>(new Mensaje("Se ha eliminado el personaje:" +id ),HttpStatus.OK);
    }

    //obtener todos los personajes, incluyendo los que no tienen peliculas
    @GetMapping("/all")
    @ApiOperation(value = "Obtiene todos los personajes, incluyendo los que no tienen peliculas", notes = "Obtiene todos los personajes, incluyendo los que no tienen peliculas")
    ResponseEntity<List<personaje>> getAllPersonajes(){
        return ResponseEntity.ok(personajeService.getAllPersonajes());
    }



    // metodo para buscar personaje por id
    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un personaje por id", notes = "Obtiene un personaje por id")
    ResponseEntity<?> getPersonajeById(@PathVariable("id") long id)  {
           if(!personajeService.existsById(id)){
               return new ResponseEntity<>(new Mensaje("El id: " + id +" no existe"),HttpStatus.NOT_FOUND);
           }
              return ResponseEntity.ok(personajeService.getPersonajeById(id));
    }


    //Listar personajes solo por nombre y imagen
    @GetMapping("/nombreImagen")
    @ApiOperation(value = "Obtiene un personaje por nombre e imagen", notes = "Obtiene un personaje por nombre e imagen")
    ResponseEntity<List<personaje.personajeProjection>> getPersonajeByNombreImagen(){
        return ResponseEntity.ok(personajeService.selectByNombreAndImagen());
    }

    // un personaje que filtra por nombre que se le pasa por parametro
    @GetMapping(params = "name")
    @ApiOperation(value = "filtra personaje por nombre", notes = "Obtiene un personaje por nombre")
    ResponseEntity<List<personaje>> findByNombreContaining(@RequestParam String name){
        if (personajeService.findByNombreContaining(name).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(personajeService.findByNombreContaining(name));
    }

    // un personaje que filtra por edad que se le pasa por parametro
    @GetMapping(params="age")
    @ApiOperation(value="filtra personaje por edad", notes="Obtiene un personaje por edad")
    ResponseEntity<List<personaje>> findByAgeEquals(@RequestParam int age){
        if (personajeService.findByEdadEquals(age).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(personajeService.findByEdadEquals(age));
    }




}
