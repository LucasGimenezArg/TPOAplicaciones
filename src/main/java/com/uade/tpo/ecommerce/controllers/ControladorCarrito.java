package com.uade.tpo.ecommerce.controllers;

import com.uade.tpo.ecommerce.dto.ItemCarritoDto;
import com.uade.tpo.ecommerce.model.Usuario;
import com.uade.tpo.ecommerce.service.CarritoService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/carrito", consumes = "application/json", produces = "application/json")
public class ControladorCarrito {
    private final CarritoService carritoService;

    public ControladorCarrito(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @GetMapping("/list")
    public Collection<ItemCarritoDto> list(@AuthenticationPrincipal Usuario usuario) {
        return carritoService.getAll(usuario);
    }

    @PostMapping("/add")
    public void addProduct(ItemCarritoDto cartItem, @AuthenticationPrincipal Usuario usuario) {
        carritoService.addOrUpdate(cartItem, usuario);
    }

    @DeleteMapping("/remove")
    public void removeProduct(Long productoId, @AuthenticationPrincipal Usuario usuario) {
        carritoService.remove(productoId, usuario);
    }

    @DeleteMapping("/clear")
    public void clear(@AuthenticationPrincipal Usuario usuario) {
        carritoService.clear(usuario);
    }

    @PostMapping("/checkout")
    public void checkout(@AuthenticationPrincipal Usuario usuario) {
        carritoService.checkout(usuario);
    }
}
