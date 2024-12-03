package com.uade.tpo.ecommerce.controllers;

import com.uade.tpo.ecommerce.dto.OrdenDto;
import com.uade.tpo.ecommerce.model.Usuario;
import com.uade.tpo.ecommerce.service.CarritoService;
import com.uade.tpo.ecommerce.service.OrdenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api/checkout")
public class ControladorCheckout {
    private final OrdenService ordenService;
    private final CarritoService carritoService;

    public ControladorCheckout(OrdenService ordenService, CarritoService carritoService) {
        this.ordenService = ordenService;
        this.carritoService = carritoService;
    }

    @GetMapping
    public ResponseEntity<List<OrdenDto>> getHistory(@AuthenticationPrincipal Usuario usuario,
                                                     @RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "10") int size) {
        try {
            if (page < 0 || size < 1) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        String.format("Parámetros de paginación inválidos: [ page = %s, size = %s ]", page, size));
            }
            return ResponseEntity.ok(ordenService.getPastOrdenes(usuario, page, size));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<OrdenDto> checkout(@AuthenticationPrincipal Usuario usuario) {
        try {
            return ordenService.checkout(usuario).map(ordenDto -> {
                carritoService.clear(usuario);
                return ordenDto;
            }).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
        } catch (IllegalArgumentException | IllegalStateException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
