package com.uade.tpo.ecommerce.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class UsuarioNormal extends Usuario {
    public UsuarioNormal(String nombreUsuario, String mail, String contrasena, String nombre, String apellido, Date fechaNacimiento) {
        super(nombreUsuario, mail, contrasena, nombre, apellido, fechaNacimiento);
    }

    public UsuarioNormal() {

    }

    @Override
    public String getRol() {
        return ROL_NORMAL;
    }
}
