package com.uade.tpo.ecommerce.model;

import com.uade.tpo.ecommerce.dto.ItemCarritoDto;
import com.uade.tpo.ecommerce.dto.OrdenDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Entity
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fecha;
    @OneToMany
    @JoinColumn(name = "orden_id", referencedColumnName = "id")
    private Collection<ItemCarrito> items;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Orden() {}
    public Orden(Usuario usuario, LocalDateTime fecha, Collection<ItemCarrito> items) {
        this.fecha = fecha;
        this.items = items;
        this.usuario = usuario;
    }

    public OrdenDto toDto() {
        AtomicReference<Double> total = new AtomicReference<>(0d);
        List<ItemCarritoDto> dtoItems = this.getItems().stream()
                .peek(itemCarrito -> total.accumulateAndGet(itemCarrito.getProducto().getPrecio() * itemCarrito.getCantidad(), Double::sum))
                .map(ItemCarrito::toDto)
                .toList();
        return new OrdenDto(this.getId(), this.getFecha(), dtoItems, total.get());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
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
