package com.uade.tpo.ecommerce.dto;

public class AutenticacionDto {
    private final String token;
    private final UsuarioAuthDto usuario;

    public AutenticacionDto(String token, UsuarioAuthDto usuario) {
        this.token = token;
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public UsuarioAuthDto getUsuario() {return usuario;}
}
