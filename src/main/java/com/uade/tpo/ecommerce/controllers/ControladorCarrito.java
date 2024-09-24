package com.uade.tpo.ecommerce.controllers;

import com.uade.tpo.ecommerce.dto.CarritoAddRequest;
import com.uade.tpo.ecommerce.dto.ItemCarritoDto;
import com.uade.tpo.ecommerce.dto.OrdenDto;
import com.uade.tpo.ecommerce.model.Usuario;
import com.uade.tpo.ecommerce.service.CarritoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api/carrito")
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
    public ItemCarritoDto addProduct(@RequestBody CarritoAddRequest request, @AuthenticationPrincipal Usuario usuario) {
        try {
            request.validate();
            return carritoService.addOrUpdate(request.getProductoId(), request.getCantidad(), usuario);
        } catch (NullPointerException | IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @DeleteMapping("/remove/{productoId}")
    public void removeProduct(@PathVariable Long productoId, @AuthenticationPrincipal Usuario usuario) {
        try {
            carritoService.remove(productoId, usuario);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @DeleteMapping("/clear")
    public void clear(@AuthenticationPrincipal Usuario usuario) {
        carritoService.clear(usuario);
    }

    @PostMapping("/checkout")
    public ResponseEntity<OrdenDto> checkout(@AuthenticationPrincipal Usuario usuario) {
        try {
            return carritoService.checkout(usuario).map(ordenDto -> {
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
