package com.uade.tpo.ecommerce.dto;

import java.util.Date;
import com.uade.tpo.ecommerce.model.Usuario;

public class UsuarioAuthDto {
    private final long idUsuario;
    private final String nombreUsuario;
    private final String mail;
    private final String nombre;
    private final String apellido;
    private final Date fechaNacimiento;

    public UsuarioAuthDto(Usuario usuario) {
        this.idUsuario = usuario.getId();
        this.nombreUsuario = usuario.getNombreUsuario();
        this.mail = usuario.getMail();
        this.nombre = usuario.getNombre();
        this.apellido = usuario.getApellido();
        this.fechaNacimiento = usuario.getFechaNacimiento();
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getMail() {
        return mail;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
}
