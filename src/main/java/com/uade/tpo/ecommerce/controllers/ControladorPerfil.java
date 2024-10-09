package com.uade.tpo.ecommerce.controllers;

import com.uade.tpo.ecommerce.dto.PerfilDto;
import com.uade.tpo.ecommerce.model.Usuario;
import com.uade.tpo.ecommerce.service.PerfilService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/perfil")
public class ControladorPerfil {
    private final PerfilService perfilService;

    public ControladorPerfil(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    @GetMapping
    public ResponseEntity<PerfilDto> obtenerPerfil(@AuthenticationPrincipal Usuario usuario) {
        PerfilDto perfil = perfilService.obtenerPerfil(usuario);
        return ResponseEntity.ok(perfil);
    }
}