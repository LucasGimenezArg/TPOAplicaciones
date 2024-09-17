package com.uade.tpo.ecommerce.model;

import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class UsuarioAdmin extends Usuario {
    public UsuarioAdmin(String nombreUsuario, String mail, String contrasena, String nombre, String apellido, Date fechaNacimiento) {
        super(nombreUsuario, mail, contrasena, nombre, apellido, fechaNacimiento);
    }

    public UsuarioAdmin() {

    }
}
