package com.proyecto.Alkemy.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.stream.Collectors;

public class usuarioPrincipal implements UserDetails {

    private String usuario;
    private String email;
    private String password;
    // Variable que nos da la autorización (no confundir con autenticación)
    // Coleccion de tipo generico que extendiende
    // de GranthedAuthority de Spring security
    private List<? extends GrantedAuthority> authorities;

    public usuarioPrincipal(String usuario, String email, String password, List<? extends GrantedAuthority> authorities) {
        this.usuario = usuario;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    //Metodo que asigna los privilegios (autorización)
    public static usuarioPrincipal build(usuario usuario){
        //Convertimos la clase Rol a la clase GrantedAuthority
        List<GrantedAuthority> authorities =
                usuario.getRoles()
                        .stream()
                        .map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name()))
                        .collect(Collectors.toList());
        return new usuarioPrincipal(usuario.getnombreUsuario(), usuario.getEmail(),
                usuario.getPassword(), authorities);
    }


    //@Overriden significa que son metodos de UserDetails de SpringSecurity

    @Override
    public List<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return usuario;
    }


    public String getEmail() {
        return email;
    }


    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
