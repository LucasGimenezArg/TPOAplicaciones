package com.uade.tpo.ecommerce.model;

import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class UsuarioNormal extends Usuario {
    public UsuarioNormal(String nombreUsuario, String mail, String contrasena, String nombre, String apellido, Date fechaNacimiento) {
        super(nombreUsuario, mail, contrasena, nombre, apellido, fechaNacimiento);
    }

    public UsuarioNormal() {

    }
}
