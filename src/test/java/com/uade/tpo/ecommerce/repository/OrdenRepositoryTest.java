package com.uade.tpo.ecommerce.repository;

import com.uade.tpo.ecommerce.model.Categoria;
import com.uade.tpo.ecommerce.model.ItemCarrito;
import com.uade.tpo.ecommerce.model.Orden;
import com.uade.tpo.ecommerce.model.Producto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.uade.tpo.ecommerce.TestUtils.USUARIO_NORMAL;
import static com.uade.tpo.ecommerce.TestUtils.buildPersistableProduct;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class OrdenRepositoryTest {
    private static final int TOTAL_ORDERS = 10;

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
    @BeforeEach
    public void setUp() {
        Categoria categoria = new Categoria(null, "Test category", "Test");
        usuarioRepository.save(USUARIO_NORMAL);
        categoriaRepository.save(categoria);
        IntStream.range(0, TOTAL_ORDERS).forEach(i -> {
            Producto producto = buildPersistableProduct(categoria);
            ItemCarrito itemCarrito = new ItemCarrito(producto, new Random().nextInt(producto.getStock()), USUARIO_NORMAL);
            Orden orden = new Orden(USUARIO_NORMAL, LocalDateTime.now(), List.of(itemCarrito));
            productoRepository.save(producto);
            carritoRepository.save(itemCarrito);
            ordenRepository.save(orden);
        });
    }

    @AfterEach
    public void cleanup() {
        ordenRepository.deleteAll();
        carritoRepository.deleteAll();
        usuarioRepository.deleteAll();
        productoRepository.deleteAll();
        categoriaRepository.deleteAll();
    }

    @Test
    public void shouldGetPaginatedOrders() {
        Page<Orden> page1 = ordenRepository.findAllByUsuario(USUARIO_NORMAL, PageRequest.of(0, TOTAL_ORDERS / 2));
        Page<Orden> page2 = ordenRepository.findAllByUsuario(USUARIO_NORMAL, PageRequest.of(1, TOTAL_ORDERS / 2));
        assertNotNull(page1);
        assertNotNull(page2);
        assertFalse(page1.isEmpty());
        assertFalse(page2.isEmpty());
        assertEquals(TOTAL_ORDERS, page1.getContent().size() + page2.getContent().size());
        assertEquals(TOTAL_ORDERS, Stream.concat(page1.stream(), page2.stream()).distinct().count());
    }
}
