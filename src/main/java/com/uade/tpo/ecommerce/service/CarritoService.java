package com.uade.tpo.ecommerce.service;

import com.uade.tpo.ecommerce.dto.ItemCarritoDto;
import com.uade.tpo.ecommerce.dto.OrdenDto;
import com.uade.tpo.ecommerce.model.ItemCarrito;
import com.uade.tpo.ecommerce.model.Orden;
import com.uade.tpo.ecommerce.model.Producto;
import com.uade.tpo.ecommerce.model.Usuario;
import com.uade.tpo.ecommerce.repository.CarritoRepository;
import com.uade.tpo.ecommerce.repository.OrdenRepository;
import com.uade.tpo.ecommerce.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

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

    public void remove(Long productoId, Usuario usuario) {
        carritoRepository.findByUsuarioAndProducto_IdAndOrdenIsNull(usuario, productoId)
                .ifPresentOrElse(carritoRepository::delete, () -> {
                    throw new IllegalArgumentException("El producto solicitado no existe en carrito");
                });
    }

    @Transactional
    public void clear(Usuario usuario) {
        carritoRepository.deleteAllByUsuarioAndOrdenIsNull(usuario);
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
            Orden orden = new Orden(LocalDate.now(), items);
            ordenRepository.save(orden);
            AtomicReference<Double> total = new AtomicReference<>(0d);
            List<ItemCarritoDto> dtoItems = orden.getItems().stream()
                    .peek(itemCarrito -> total.accumulateAndGet(itemCarrito.getProducto().getPrecio() * itemCarrito.getCantidad(), Double::sum))
                    .map(ItemCarrito::toDto)
                    .toList();
            return Optional.of(new OrdenDto(orden.getId(), orden.getFecha(), dtoItems, total.get()));
        } else {
            return Optional.empty();
        }
    }
}
