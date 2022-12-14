package com.proyecto.Alkemy.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "personaje")
public class personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personaje")
    private Long id_personaje;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name = "edad", nullable = false, length = 3)
    private int edad;
    @Column(name = "peso", nullable = false, length = 3)
    private double peso;
    @Column(name = "historia", nullable = false, length = 500)
    private String historia;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "PERSONAJE_PELICULA_TABLE",
            joinColumns = @JoinColumn(name = "id_personaje",referencedColumnName ="id_personaje" ),
            inverseJoinColumns = @JoinColumn(name = "id_pelicula", referencedColumnName = "id_pelicula")
            )
    @JsonManagedReference
    private Set<pelicula> peliculas= new HashSet<>();


    public Long getId_personaje() {
        return id_personaje;
    }

    public void setId_personaje(Long id_personaje) {
        this.id_personaje = id_personaje;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }



    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public Set<pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(Set<pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public long getId() {
        return id_personaje;
    }

    public void setId(long id_personaje) {
    }

    public interface personajeProjection {
        String getImagen();
        String getNombre();

    }
}
