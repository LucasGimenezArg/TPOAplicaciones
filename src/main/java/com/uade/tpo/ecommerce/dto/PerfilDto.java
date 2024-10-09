package com.uade.tpo.ecommerce.dto;

import java.util.List;

public class PerfilDto {
    private String nombre;
    private String apellido;
    private String mail;
    private List<OrdenDto> transacciones;

    public PerfilDto(String nombre, String apellido, String mail, List<OrdenDto> transacciones) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.transacciones = transacciones;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getMail() {
        return mail;
    }

    public List<OrdenDto> getTransacciones() {
        return transacciones;
    }
}