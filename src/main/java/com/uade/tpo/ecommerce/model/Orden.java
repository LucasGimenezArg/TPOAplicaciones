package com.uade.tpo.ecommerce.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Collection;

@Entity
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    @OneToMany
    @JoinColumn(name = "orden_id", referencedColumnName = "id")
    private Collection<ItemCarrito> items;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
