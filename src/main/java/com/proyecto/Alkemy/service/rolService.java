package com.proyecto.Alkemy.service;


import com.proyecto.Alkemy.models.rol;
import com.proyecto.Alkemy.models.rolNombre;
import com.proyecto.Alkemy.repository.rolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class rolService {
    @Autowired
    rolRepository rolRepository;

    public Optional<rol> getByrolNombre(rolNombre rolNombre) {
        return rolRepository.findByrolNombre(rolNombre);
    }

    public void save(rol rol){
        rolRepository.save(rol);
    }


}
