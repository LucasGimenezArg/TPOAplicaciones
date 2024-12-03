package com.uade.tpo.ecommerce.service;

import com.uade.tpo.ecommerce.dto.ItemCarritoDto;
import com.uade.tpo.ecommerce.model.ItemCarrito;
import com.uade.tpo.ecommerce.model.Usuario;
import com.uade.tpo.ecommerce.repository.CarritoRepository;
import com.uade.tpo.ecommerce.repository.OrdenRepository;
import com.uade.tpo.ecommerce.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CarritoService {
    private final CarritoRepository carritoRepository;
    private final ProductoRepository productoRepository;
    private final OrdenRepository ordenRepository;

    public CarritoService(CarritoRepository carritoRepository, ProductoRepository productoRepository, OrdenRepository ordenRepository) {
        this.carritoRepository = carritoRepository;
        this.productoRepository = productoRepository;
        this.ordenRepository = ordenRepository;
    }

    public Collection<ItemCarritoDto> getAll(Usuario usuario) {
        return carritoRepository.findAllByUsuarioAndOrdenIsNull(usuario).stream()
                .map(ItemCarrito::toDto)
                .toList();
    }

    @Transactional
    public ItemCarritoDto addOrUpdate(long productoId, int cantidad, Usuario usuario) {
        ItemCarrito itemCarrito = carritoRepository.findByUsuarioAndProducto_IdAndOrdenIsNull(usuario, productoId)
                .or(() -> productoRepository.findById(productoId)
                        .map(producto -> new ItemCarrito(producto, cantidad, usuario)))
                .orElseThrow(() -> new IllegalArgumentException("El producto solicitado no existe"));
        if (cantidad > itemCarrito.getProducto().getStock()) {
            throw new IllegalArgumentException("No hay suficiente stock del producto #" + itemCarrito.getProducto().getId());
        }
        itemCarrito.setCantidad(cantidad);
        return carritoRepository.save(itemCarrito).toDto();
    }

    public void remove(Long itemId) {
        carritoRepository.deleteById(itemId);
    }

    @Transactional
    public void clear(Usuario usuario) {
        carritoRepository.deleteAllByUsuarioAndOrdenIsNull(usuario);
    }
}
