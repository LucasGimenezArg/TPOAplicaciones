package com.uade.tpo.ecommerce.dto;

public class ItemCarritoDto {
    private final Long id;
    private final ProductoDto producto;
    private final Integer cantidad;

    public ItemCarritoDto(Long id, ProductoDto producto, Integer cantidad) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public ProductoDto getProducto() {
        return producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }
}
