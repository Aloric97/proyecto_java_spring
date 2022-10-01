package com.proyecto.Alkemy.testUser;


import com.proyecto.Alkemy.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CrearUsuario {

    @Test
    void Crear() {
        User user = new User("test", "test@gmail.com", "test");
        // In a grouped assertion all assertions are executed, and any
        // failures will be reported together.
        assertAll("user", () -> assertEquals("test", user.getUsername()),
                () -> assertEquals("test@gmail.com", user.getEmail()),
                () -> assertEquals("test", user.getPassword()));

    }

    //Comprobar si acepta valores nulos
}
