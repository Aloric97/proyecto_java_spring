package com.proyecto.Alkemy.util;

import com.proyecto.Alkemy.models.rol;
import com.proyecto.Alkemy.models.rolNombre;
import com.proyecto.Alkemy.service.rolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class createRoles  implements CommandLineRunner {
    @Autowired
    rolService rolService;

    @Override
    public void run(String... args) throws Exception {

        rol rolAdmin = new rol(rolNombre.ROLE_ADMIN,"es un usuario que tiene todos los permisos");
        rol rolUser = new rol(rolNombre.ROLE_USER,"es un usuario que tiene permisos limitados");
        rolService.save(rolAdmin);
        rolService.save(rolUser);
        System.out.println("--------------------------------------");
        System.out.println("ROLES CREADOS DE FORMA EXITOSA");

    }
}
