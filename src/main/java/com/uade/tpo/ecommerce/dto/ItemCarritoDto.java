package com.uade.tpo.ecommerce.dto;

import com.uade.tpo.ecommerce.model.Producto;

public class ItemCarritoDto {
    private final ProductoDto producto;
    private final int cantidad;

    public ItemCarritoDto(ProductoDto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public ProductoDto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }
}
