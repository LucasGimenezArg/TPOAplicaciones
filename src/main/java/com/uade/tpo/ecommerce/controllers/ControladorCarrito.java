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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api/carrito")
public class ControladorCarrito {
    private final CarritoService carritoService;

    public ControladorCarrito(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @GetMapping
    public Collection<ItemCarritoDto> list(@AuthenticationPrincipal Usuario usuario) {
        return carritoService.getAll(usuario);
    }

    @PutMapping
    public ItemCarritoDto addOrUpdate(@RequestBody CarritoAddRequest request, @AuthenticationPrincipal Usuario usuario) {
        try {
            request.validate();
            return carritoService.addOrUpdate(request.getProductoId(), request.getCantidad(), usuario);
        } catch (NullPointerException | IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @DeleteMapping("/{itemId}")
    public void remove(@PathVariable Long itemId) {
        try {
            Objects.requireNonNull(itemId, "El ID del item a eliminar es requerido");
            carritoService.remove(itemId);
        } catch (NullPointerException | IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @DeleteMapping
    public void clear(@AuthenticationPrincipal Usuario usuario) {
        carritoService.clear(usuario);
    }
}
