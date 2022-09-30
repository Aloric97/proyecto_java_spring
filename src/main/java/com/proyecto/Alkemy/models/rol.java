package com.proyecto.Alkemy.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rol")
public class rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_rol;

    //Se indica que va a ser un Enum de tipo String
    @Enumerated(EnumType.STRING)
    private rolNombre rolNombre;

    private String rol_descripcion;

    public rol() {
    }

    public rol(rolNombre rolNombre, String rol_descripcion) {
        this.rolNombre = rolNombre;
        this.rol_descripcion = rol_descripcion;
    }

    public rol(rolNombre rolNombre) {
    }


    public long getId_rol() {
        return id_rol;
    }

    public void setId_rol(long id_rol) {
        this.id_rol = id_rol;
    }

    public rolNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(rolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }

    public String getRol_descripcion() {
        return rol_descripcion;
    }

    public void setRol_descripcion(String rol_descripcion) {
        this.rol_descripcion = rol_descripcion;
    }
}
