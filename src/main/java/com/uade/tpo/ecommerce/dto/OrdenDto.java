package com.uade.tpo.ecommerce.dto;

import com.uade.tpo.ecommerce.model.ItemCarrito;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

public class OrdenDto {
    private final Long id;
    private final LocalDateTime fecha;
    private final Collection<ItemCarritoDto> items;
    private final double total;

    public OrdenDto(Long id, LocalDateTime fecha, Collection<ItemCarritoDto> items, double total) {
        this.id = id;
        this.fecha = fecha;
        this.items = items;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Collection<ItemCarritoDto> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }
}
