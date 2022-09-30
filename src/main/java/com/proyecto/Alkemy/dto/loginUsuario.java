package com.proyecto.Alkemy.dto;

import javax.validation.constraints.NotBlank;

public class loginUsuario {
    @NotBlank
    private String usuarioNombre;
    @NotBlank
    private String password;

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
