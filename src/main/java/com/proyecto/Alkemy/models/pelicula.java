package com.proyecto.Alkemy.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pelicula")
public class pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private Long id_pelicula;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;

    @Column(name = "fecha_creacion")
    @JsonFormat(pattern="yyyy/MM/dd")
    private Date fecha_creacion;

    @Column(name = "calificacion")
    private int calificacion;

    @ManyToMany(mappedBy = "peliculas")
    @JsonIgnore
    private List<personaje> personajes;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "id_genero")
    private genero generoID;


    public pelicula() {
    }


    // para consultar peliculas por campos especificos, en este caso por imagen, titulo y fecha de creacion
    public interface peliculaProjection {
        String getImagen();
        String getTitulo();
        Date getFecha_creacion();

    }

    public pelicula(Long id_pelicula, String imagen, String titulo, Date fecha_creacion, int calificacion, genero generoID) {
        this.id_pelicula = id_pelicula;
        this.imagen = imagen;
        this.titulo = titulo;
        this.fecha_creacion = fecha_creacion;
        this.calificacion = calificacion;
        this.generoID = generoID;
    }

    public Long getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(Long id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public List<personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(List<personaje> personajes) {
        this.personajes = personajes;
    }

    public genero getGeneroID() {
        return generoID;
    }

    public void setGeneroID(genero generoID) {
        this.generoID = generoID;
    }
}
