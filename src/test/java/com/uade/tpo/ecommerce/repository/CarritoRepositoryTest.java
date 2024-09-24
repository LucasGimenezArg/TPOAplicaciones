package com.uade.tpo.ecommerce.repository;

import com.uade.tpo.ecommerce.model.Categoria;
import com.uade.tpo.ecommerce.model.ItemCarrito;
import com.uade.tpo.ecommerce.model.Orden;
import com.uade.tpo.ecommerce.model.Producto;
import com.uade.tpo.ecommerce.model.UsuarioNormal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class CarritoRepositoryTest {
    @Autowired
    private CarritoRepository carritoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private OrdenRepository ordenRepository;

    private Categoria categoria;
    private Producto producto1;
    private Producto producto2;
    private UsuarioNormal usuario;

    @BeforeEach
    public void setUp() {
        categoria = new Categoria(null, "Test category", "Test");
        producto1 = new Producto(null, "Test product 1", 150, 1000, categoria, "Test info 1", new ArrayList<>());
        producto2 = new Producto(null, "Test product 2", 150, 1000, categoria, "Test info 2", new ArrayList<>());
        usuario = new UsuarioNormal(
                "test", "test@test.com", "test", "Juan Carlos", "Test", new Date());
        usuarioRepository.save(usuario);
        categoriaRepository.save(categoria);
        productoRepository.save(producto1);
        productoRepository.save(producto2);
    }

    @AfterEach
    public void cleanup() {
        usuarioRepository.deleteAll();
        productoRepository.deleteAll();
        categoriaRepository.deleteAll();
    }

    @Test
    public void shouldFindAllByUsuarioAndOrdenIsNull() {
        ItemCarrito itemCarrito1 = new ItemCarrito(producto1, 10, usuario);
        ItemCarrito itemCarrito2 = new ItemCarrito(producto2, 5, usuario);
        carritoRepository.save(itemCarrito1);
        carritoRepository.save(itemCarrito2);
        Orden orden = new Orden(LocalDate.now(), List.of(itemCarrito1));
        itemCarrito1.setOrden(orden);
        ordenRepository.save(orden);

        Collection<ItemCarrito> items = carritoRepository.findAllByUsuarioAndOrdenIsNull(usuario);
        assertNotNull(items);
        assertFalse(items.isEmpty());
        assertEquals(1, items.size());
    }

    @Test
    public void shouldFindByUsuarioAndProducto_IdAndOrdenIsNull() {
        ItemCarrito itemCarrito1 = new ItemCarrito(producto1, 10, usuario);
        ItemCarrito itemCarrito2 = new ItemCarrito(producto2, 5, usuario);
        carritoRepository.save(itemCarrito1);
        carritoRepository.save(itemCarrito2);
        Orden orden = new Orden(LocalDate.now(), List.of(itemCarrito1));
        itemCarrito1.setOrden(orden);
        ordenRepository.save(orden);

        Optional<ItemCarrito> result = carritoRepository.findByUsuarioAndProducto_IdAndOrdenIsNull(usuario, itemCarrito2.getProducto().getId());
        assertFalse(result.isEmpty());
        assertEquals(itemCarrito2.getProducto().getId(), result.get().getProducto().getId());
    }

    @Test
    public void shouldDeleteAllByUsuarioAndOrdenIsNull() {
        ItemCarrito itemCarrito1 = new ItemCarrito(producto1, 10, usuario);
        ItemCarrito itemCarrito2 = new ItemCarrito(producto2, 5, usuario);
        carritoRepository.save(itemCarrito1);
        carritoRepository.save(itemCarrito2);
        Orden orden = new Orden(LocalDate.now(), List.of(itemCarrito1));
        itemCarrito1.setOrden(orden);
        ordenRepository.save(orden);

        carritoRepository.deleteAllByUsuarioAndOrdenIsNull(usuario);

        List<ItemCarrito> allItems = carritoRepository.findAll();
        Optional<ItemCarrito> item2 = carritoRepository.findByUsuarioAndProducto_IdAndOrdenIsNull(usuario, producto2.getId());

        assertEquals(1, allItems.size());
        assertTrue(allItems.contains(itemCarrito1));
        assertTrue(item2.isEmpty());
    }
}
