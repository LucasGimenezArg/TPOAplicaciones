package com.uade.tpo.ecommerce.model;

import com.uade.tpo.ecommerce.dto.ItemCarritoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
public class ItemCarrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;
    private int cantidad;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "orden_id")
    private Orden orden;

    public ItemCarrito() {
    }

    public ItemCarrito(Producto producto, int cantidad, Usuario usuario) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.usuario = usuario;
    }

    public ItemCarritoDto toDto() {
        return new ItemCarritoDto(producto.toDto(), cantidad);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
