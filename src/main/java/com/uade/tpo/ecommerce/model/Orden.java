package com.uade.tpo.ecommerce.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.Collection;

@Entity
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    @OneToMany(targetEntity = ItemCarrito.class, cascade = CascadeType.ALL)
    private Collection<ItemCarrito> items;

    public Orden() {}
    public Orden(LocalDate fecha, Collection<ItemCarrito> items) {
        this.fecha = fecha;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Collection<ItemCarrito> getItems() {
        return items;
    }

    public void setItems(Collection<ItemCarrito> items) {
        this.items = items;
    }
}
