package com.uade.tpo.ecommerce.service;

import com.uade.tpo.ecommerce.dto.OrdenDto;
import com.uade.tpo.ecommerce.dto.PageDto;
import com.uade.tpo.ecommerce.model.ItemCarrito;
import com.uade.tpo.ecommerce.model.Orden;
import com.uade.tpo.ecommerce.model.Producto;
import com.uade.tpo.ecommerce.model.Usuario;
import com.uade.tpo.ecommerce.repository.CarritoRepository;
import com.uade.tpo.ecommerce.repository.OrdenRepository;
import com.uade.tpo.ecommerce.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

@Service
public class OrdenService {
    private final CarritoRepository carritoRepository;
    private final ProductoRepository productoRepository;
    private final OrdenRepository ordenRepository;

    public OrdenService(CarritoRepository carritoRepository, ProductoRepository productoRepository, OrdenRepository ordenRepository) {
        this.carritoRepository = carritoRepository;
        this.productoRepository = productoRepository;
        this.ordenRepository = ordenRepository;
    }

    public PageDto<OrdenDto> getPastOrdenes(Usuario usuario, int page, int size) {
        Page<Orden> result = ordenRepository.findAllByUsuario(usuario, PageRequest.of(page, size, Sort.by("fecha").descending()));
        return new PageDto<>(result.getContent().stream().map(Orden::toDto).toList(), page, size, result.getTotalPages());
    }

    @Transactional
    public Optional<OrdenDto> checkout(Usuario usuario) {
        Collection<ItemCarrito> items = carritoRepository.findAllByUsuarioAndOrdenIsNull(usuario);
        items.forEach(itemCarrito -> {
            Producto producto = itemCarrito.getProducto();
            if (producto.getStock() < itemCarrito.getCantidad()) {
                throw new IllegalStateException("El producto solicitado no existe");
            }
            producto.setStock(producto.getStock() - itemCarrito.getCantidad());
            productoRepository.save(producto);
        });
        if (!items.isEmpty()) {
            Orden orden = new Orden(usuario, LocalDateTime.now(), items);
            ordenRepository.save(orden);
            return Optional.of(orden.toDto());
        } else {
            return Optional.empty();
        }
    }
}
