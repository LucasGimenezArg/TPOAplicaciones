package com.uade.tpo.ecommerce.service;

import com.uade.tpo.ecommerce.dto.ItemCarritoDto;
import com.uade.tpo.ecommerce.dto.OrdenDto;
import com.uade.tpo.ecommerce.model.Categoria;
import com.uade.tpo.ecommerce.model.ItemCarrito;
import com.uade.tpo.ecommerce.model.Producto;
import com.uade.tpo.ecommerce.model.UsuarioNormal;
import com.uade.tpo.ecommerce.repository.CarritoRepository;
import com.uade.tpo.ecommerce.repository.OrdenRepository;
import com.uade.tpo.ecommerce.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CarritoServiceTest {
    private static final UsuarioNormal USUARIO = new UsuarioNormal(
            "test", "test@test.com", "test", "Juan Carlos", "Test", new Date());

    private CarritoService carritoService;
    private CarritoRepository carritoRepository;
    private ProductoRepository productoRepository;
    private OrdenRepository ordenRepository;

    @BeforeEach
    public void setUp() {
        carritoRepository = mock(CarritoRepository.class);
        productoRepository = mock(ProductoRepository.class);
        ordenRepository = mock(OrdenRepository.class);
        carritoService = new CarritoService(carritoRepository, productoRepository, ordenRepository);
    }

    @Test
    public void shouldGetAll() {
        Producto expectedProducto = buildRandomProduct();
        ItemCarrito expectedItemCarrito = new ItemCarrito(expectedProducto, 10, USUARIO);
        List<ItemCarrito> expectedItems = List.of(expectedItemCarrito);
        when(carritoRepository.findAllByUsuarioAndOrdenIsNull(eq(USUARIO))).thenReturn(expectedItems);

        Collection<ItemCarritoDto> result = carritoService.getAll(USUARIO);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        ItemCarritoDto itemCarritoDto = result.stream().findFirst().get();
        assertEquals(expectedProducto.getId(), itemCarritoDto.getProducto().getId());
        assertEquals(expectedItemCarrito.getCantidad(), itemCarritoDto.getCantidad());
    }

    @Test
    public void shouldAddNewItem() {
        Producto producto = buildRandomProduct();
        ItemCarritoDto inputCarritoDto = new ItemCarritoDto(producto.toDto(), 10);
        when(carritoRepository.findByUsuarioAndProducto_IdAndOrdenIsNull(eq(USUARIO), eq(inputCarritoDto.getProducto().getId())))
                .thenReturn(Optional.empty());
        when(productoRepository.findById(producto.getId())).thenReturn(Optional.of(producto));

        carritoService.addOrUpdate(inputCarritoDto, USUARIO);

        ArgumentCaptor<ItemCarrito> itemCarritoArgumentCaptor = ArgumentCaptor.forClass(ItemCarrito.class);
        verify(carritoRepository).save(itemCarritoArgumentCaptor.capture());
        ItemCarrito savedItem = itemCarritoArgumentCaptor.getValue();
        assertNotNull(savedItem);
        assertEquals(producto.getId(), savedItem.getProducto().getId());
        assertEquals(USUARIO.getId(), savedItem.getUsuario().getId());
        assertEquals(inputCarritoDto.getCantidad(), savedItem.getCantidad());
    }

    @Test
    public void shouldUpdateExistingItem() {
        Producto producto = buildRandomProduct();
        ItemCarritoDto inputCarritoDto = new ItemCarritoDto(producto.toDto(), 50);
        ItemCarrito expectedItemCarrito = new ItemCarrito(producto, 10, USUARIO);
        when(carritoRepository.findByUsuarioAndProducto_IdAndOrdenIsNull(eq(USUARIO), eq(inputCarritoDto.getProducto().getId())))
                .thenReturn(Optional.of(expectedItemCarrito));

        carritoService.addOrUpdate(inputCarritoDto, USUARIO);

        verify(productoRepository, times(0)).findById(any());
        ArgumentCaptor<ItemCarrito> itemCarritoArgumentCaptor = ArgumentCaptor.forClass(ItemCarrito.class);
        verify(carritoRepository).save(itemCarritoArgumentCaptor.capture());
        ItemCarrito savedItem = itemCarritoArgumentCaptor.getValue();
        assertNotNull(savedItem);
        assertEquals(producto.getId(), savedItem.getProducto().getId());
        assertEquals(USUARIO.getId(), savedItem.getUsuario().getId());
        assertEquals(inputCarritoDto.getCantidad(), savedItem.getCantidad());
    }

    @Test
    public void shouldThrowWhenAddingInvalidProduct() {
        when(carritoRepository.findByUsuarioAndProducto_IdAndOrdenIsNull(eq(USUARIO), any()))
                .thenReturn(Optional.empty());
        when(productoRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class,
                () -> carritoService.addOrUpdate(new ItemCarritoDto(buildRandomProduct().toDto(), 10), USUARIO));
    }

    @Test
    public void shouldRemoveProduct() {
        Producto producto = buildRandomProduct();
        ItemCarrito expectedItem = new ItemCarrito(producto, 10, USUARIO);
        when(carritoRepository.findByUsuarioAndProducto_IdAndOrdenIsNull(eq(USUARIO), eq(producto.getId())))
                .thenReturn(Optional.of(expectedItem));

        carritoService.remove(producto.getId(), USUARIO);

        verify(carritoRepository).delete(eq(expectedItem));
    }

    @Test
    public void shouldThrowWhenRemovingInvalidProduct() {
        when(carritoRepository.findByUsuarioAndProducto_IdAndOrdenIsNull(eq(USUARIO), anyLong()))
                .thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> carritoService.remove(1L, USUARIO));
    }

    @Test
    public void shouldClear() {
        carritoService.clear(USUARIO);
        verify(carritoRepository).deleteAllByUsuarioAndOrdenIsNull(eq(USUARIO));
    }

    @Test
    public void shouldCheckout() {
        List<ItemCarrito> expectedItems = List.of(new ItemCarrito(buildRandomProduct(), 10, USUARIO),
                new ItemCarrito(buildRandomProduct(), 20, USUARIO),
                new ItemCarrito(buildRandomProduct(), 30, USUARIO));
        Double expectedTotal = expectedItems.stream()
                .map(item -> item.getProducto().getPrecio() * item.getCantidad())
                .reduce(Double::sum)
                .orElse(-1D);
        when(carritoRepository.findAllByUsuarioAndOrdenIsNull(eq(USUARIO))).thenReturn(expectedItems);

        OrdenDto result = carritoService.checkout(USUARIO);

        verify(ordenRepository).save(any());
        assertEquals(LocalDate.now(), result.getFecha());
        assertTrue(result.getTotal() > 0);
        assertEquals(expectedTotal, result.getTotal());
        assertEquals(expectedItems.size(), result.getItems().size());
    }

    private Producto buildRandomProduct() {
        long randomId = new Random().nextLong();
        Categoria categoria = new Categoria(randomId, "Test category " + randomId, "Test" + randomId);
        return new Producto(randomId, "Test product " + randomId, 150, 1000, categoria, "Test info " + randomId, new ArrayList<>());
    }
}
