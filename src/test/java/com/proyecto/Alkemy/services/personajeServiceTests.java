package com.proyecto.Alkemy.services;


import com.proyecto.Alkemy.exception.ResourceNotFoundException;
import com.proyecto.Alkemy.models.personaje;
import com.proyecto.Alkemy.repository.personajeRepository;
import com.proyecto.Alkemy.service.personajeService;
import com.proyecto.Alkemy.service.personajeServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class personajeServiceTests {

    @Mock
    private personajeRepository personajeRepository;

    @InjectMocks
    private com.proyecto.Alkemy.service.personajeServiceImp personajeServiceImp;

    @Mock
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

    @DisplayName("Test para guardar un personaje")
    @Test
    public void testGuardarPersonaje(){
        //given - dado o condicion inicial


        //when - accion o comportamiento que vamos a probar
        personaje personajeGuardado = personajeServiceImp.save(personaje1);

        //then - resultado esperado
        assertThat(personajeGuardado).isNotNull();
    }


    @DisplayName("Test para obtener todos los personajes")
    @Test
    void listarPersonaje(){
        //given
        personaje personaje2 = new personaje();
        personaje2.setNombre("lea");
        personaje2.setEdad(25);
        personaje2.setPeso(100);
        personaje2.setHistoria("Historia de lea");
        personaje2.setImagen("imagen de lea");

        //when
        given(personajeRepository.findAll()).willReturn(List.of(personaje1,personaje2));
        List<personaje> personajes = personajeRepository.findAll();

        //then
        assertThat(personajes).isNotNull(); //verificamos que no sea nulo
        assertThat(personajes.size()).isGreaterThan(0); //verificamos que tenga al menos un elemento
        assertThat(personajes.size()).isEqualTo(2); //verificamos que tenga 2 elementos
    }

    @DisplayName("Test para obtener un personaje por id")
    @Test
    void obtenerPersonajePorId(){
        //given
        Long id = 1L;

        //when
        given(personajeRepository.findById(id)).willReturn(Optional.of(personaje1));
        personaje personaje = personajeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No se encontro el personaje con id: " + id));

        //then
        assertThat(personaje).isNotNull();


    }

    @DisplayName("Test para actualizar un personaje")
    @Test
    void actualizarPersonaje(){
        //given

        //when
        given(personajeRepository.save(any(personaje.class))).willReturn(personaje1);

        personaje1.setNombre("probando");
        personaje1.setEdad(30);
        personaje1.setPeso(123);
        personaje1.setHistoria("una historia de prueba");
        personaje1.setImagen("una imagen de prueba");

        personaje personajeActualizado = personajeServiceImp.save(personaje1);

        //then
        assertThat(personajeActualizado.getNombre()).isEqualTo("probando");
        assertThat((personajeActualizado.getEdad())).isEqualTo(30);
        assertThat(personajeActualizado.getPeso()).isEqualTo(123);
        assertThat(personajeActualizado.getHistoria()).isEqualTo("una historia de prueba");
        assertThat(personajeActualizado.getImagen()).isEqualTo("una imagen de prueba");
    }

    @DisplayName("Test para eliminar un personaje")
    @Test
    void eliminarPersonaje(){
        //given
        Long idpersonaje = 5L;
        willDoNothing().given(personajeRepository).deleteById(idpersonaje);

        //when
        personajeServiceImp.
        //then
        verify(personajeRepository).deleteById(idpersonaje);
    }


}
