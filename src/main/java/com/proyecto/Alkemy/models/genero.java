package com.proyecto.Alkemy.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genero")
public class genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genero")
    private Long id_genero;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "imagen")
    private String imagen;

    @OneToMany(mappedBy = "generoID", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<pelicula> peliculas;

    public Long getId_genero() {
        return id_genero;
    }

    public void setId_genero(Long id_genero) {
        this.id_genero = id_genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<pelicula> peliculas) {
        this.peliculas = peliculas;
    }
}
