package com.uade.tpo.ecommerce.dto;

import java.util.Objects;

public class CarritoAddRequest {
    private final Long productoId;
    private final Integer cantidad;

    public CarritoAddRequest(Long productoId, Integer cantidad) {
        this.productoId = productoId;
        this.cantidad = cantidad;
    }

    public void validate() {
        Objects.requireNonNull(productoId, "El productId es requerido");
        Objects.requireNonNull(cantidad, "La cantidad es requerida");
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que 0");
        }
    }

    public Long getProductoId() {
        return productoId;
    }

    public int getCantidad() {
        return cantidad;
    }
}
