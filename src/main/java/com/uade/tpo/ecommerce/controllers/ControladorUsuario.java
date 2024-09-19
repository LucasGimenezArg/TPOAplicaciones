package com.uade.tpo.ecommerce.controllers;

import com.uade.tpo.ecommerce.dto.AutenticacionDto;
import com.uade.tpo.ecommerce.model.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.uade.tpo.ecommerce.model.UsuarioAdmin;
import com.uade.tpo.ecommerce.model.UsuarioNormal;
import com.uade.tpo.ecommerce.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class ControladorUsuario {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/normal")
    public AutenticacionDto registrarUsuarioNormal(@RequestBody UsuarioNormal usuarioNormalObjeto) {
        return usuarioService.crearCliente(
                usuarioNormalObjeto.getNombreUsuario(),
                usuarioNormalObjeto.getMail(),
                usuarioNormalObjeto.getContrasena(),
                usuarioNormalObjeto.getNombre(),
                usuarioNormalObjeto.getApellido(),
                usuarioNormalObjeto.getFechaNacimiento()
        );
    }

    @PostMapping("/admin")
    public AutenticacionDto registrarAdministrador(@RequestBody UsuarioAdmin usuarioAdminObjeto) {
        return usuarioService.crearAdministrador(
                usuarioAdminObjeto.getNombreUsuario(),
                usuarioAdminObjeto.getMail(),
                usuarioAdminObjeto.getContrasena(),
                usuarioAdminObjeto.getNombre(),
                usuarioAdminObjeto.getApellido(),
                usuarioAdminObjeto.getFechaNacimiento()
        );
    }

    @PostMapping("/login")
    public AutenticacionDto logearse(@RequestBody LoginRequest loginRequest) {
        return usuarioService.autenticarUsuario(loginRequest.getCredencial(), loginRequest.getContrasena());
    }
}