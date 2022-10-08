/* package com.proyecto.Alkemy.repository;

import com.proyecto.Alkemy.models.personaje;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest //nos permite testear la capa de persistencia
public class personajeRepository {

    @Autowired
    private personajeRepository personajeRepository;

    private personaje personaje1;

    @BeforeEach
    public void setUp() {
        personaje1 = new personaje();
        personaje1.setNombre("Pepe");
        personaje1.setEdad(20);
        personaje1.setPeso(80);
        personaje1.setHistoria("Historia de pepe");
        personaje1.setImagen("imagen de pepe");
    }


    @Test
    public void testGuardarPersonaje(){

        //when - accion o comportamiento que vamos a probar
        personaje personajeGuardad =personajeRepository.personaje1.


        //then - resultado esperado
        assertThat(personajeGuardado).isNotNull();
    }

}
*/