package com.proyecto.Alkemy.service;

import com.proyecto.Alkemy.models.usuario;
import com.proyecto.Alkemy.repository.usuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class usuarioService {

    @Autowired
    usuarioRepository usuarioRepository;


    Optional<usuario> getByUsuarioNombre(String usuarioNombre) {
        return usuarioRepository.findByNombreUsuario(usuarioNombre);
    }

    public boolean existsByUsuarioNombre(String usuarioNombre){
        return usuarioRepository.existsByNombreUsuario(usuarioNombre);
    }

    public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public void save(usuario usuario){
        usuarioRepository.save(usuario);
    }


}
