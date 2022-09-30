package com.proyecto.Alkemy.controllers;

import com.proyecto.Alkemy.dto.jwtDto;
import com.proyecto.Alkemy.dto.loginUsuario;
import com.proyecto.Alkemy.dto.mensaje;
import com.proyecto.Alkemy.dto.nuevoUsuario;
import com.proyecto.Alkemy.models.rol;
import com.proyecto.Alkemy.models.rolNombre;
import com.proyecto.Alkemy.models.usuario;
import com.proyecto.Alkemy.security.jwt.JwtProvider;
import com.proyecto.Alkemy.service.rolService;
import com.proyecto.Alkemy.service.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class authController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    usuarioService usuarioService;

    @Autowired
    rolService rolService;

    @Autowired
    JwtProvider jwtProvider;


    //Espera un json y lo convierte a tipo clase NuevoUsuario
    @PostMapping("/nuevoUsuario")
    public ResponseEntity<?> nuevoUsuario(@Valid @RequestBody nuevoUsuario nuevoUsuario,
                                          BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(new mensaje("Campos mal o email invalido"), HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.existsByUsuarioNombre(nuevoUsuario.getUsuarioNombre())){
            return new ResponseEntity<>(new mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail())){
            return new ResponseEntity<>(new mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);
        }

        usuario usuario = new usuario( nuevoUsuario.getUsuarioNombre(),
                nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));

        Set<rol> roles = new HashSet<>();
        roles.add(rolService.getByrolNombre(rolNombre.ROLE_USER).get());

        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByrolNombre(rolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);

        usuarioService.save(usuario);

        return new ResponseEntity<>(new mensaje("Usuario creado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<jwtDto> login(@Valid @RequestBody loginUsuario loginUsuario, BindingResult bindingResult){

        if (bindingResult.hasErrors())
            return new ResponseEntity(new mensaje("Campos mal"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginUsuario.getUsuarioNombre(),
                                loginUsuario.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        jwtDto jwtDto = new jwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity<>(jwtDto, HttpStatus.OK);
    }
}
