package com.proyecto.Alkemy.service;

import com.proyecto.Alkemy.models.usuario;
import com.proyecto.Alkemy.models.usuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


/**
 * Clase que convierte la clase usuario en un usuarioPrincipal
 * UserDetailsService es propia de Spring Security
 */
@Service
@Transactional
public class userDetailsServiceImpl implements UserDetailsService {

    @Autowired
    usuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        usuario usuario = usuarioService.getByUsuarioNombre(nombreUsuario).get();
        return usuarioPrincipal.build(usuario);
    }
}
