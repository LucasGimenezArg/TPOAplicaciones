package com.uade.tpo.ecommerce.dto;

public class AutenticacionDto {
    private final String token;

    public AutenticacionDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
