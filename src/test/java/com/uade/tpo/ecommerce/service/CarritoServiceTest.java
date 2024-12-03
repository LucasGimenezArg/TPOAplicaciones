package com.uade.tpo.ecommerce.service;

import com.uade.tpo.ecommerce.dto.ItemCarritoDto;
import com.uade.tpo.ecommerce.model.ItemCarrito;
import com.uade.tpo.ecommerce.model.Producto;
import com.uade.tpo.ecommerce.model.UsuarioNormal;
import com.uade.tpo.ecommerce.repository.CarritoRepository;
import com.uade.tpo.ecommerce.repository.OrdenRepository;
import com.uade.tpo.ecommerce.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static com.uade.tpo.ecommerce.TestUtils.USUARIO_NORMAL;
import static com.uade.tpo.ecommerce.TestUtils.buildRandomProduct;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CarritoServiceTest {
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
        ItemCarrito expectedItemCarrito = new ItemCarrito(expectedProducto, 10, USUARIO_NORMAL);
        List<ItemCarrito> expectedItems = List.of(expectedItemCarrito);
        when(carritoRepository.findAllByUsuarioAndOrdenIsNull(eq(USUARIO_NORMAL))).thenReturn(expectedItems);

        Collection<ItemCarritoDto> result = carritoService.getAll(USUARIO_NORMAL);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        ItemCarritoDto itemCarritoDto = result.stream().findFirst().get();
        assertEquals(expectedProducto.getId(), itemCarritoDto.getProducto().getId());
        assertEquals(expectedItemCarrito.getCantidad(), itemCarritoDto.getCantidad());
    }

    @Test
    public void shouldAddNewItem() {
        Producto producto = buildRandomProduct();
        when(carritoRepository.findByUsuarioAndProducto_IdAndOrdenIsNull(eq(USUARIO_NORMAL), eq(producto.getId())))
                .thenReturn(Optional.empty());
        when(productoRepository.findById(producto.getId())).thenReturn(Optional.of(producto));
        when(carritoRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);

        carritoService.addOrUpdate(producto.getId(), 10, USUARIO_NORMAL);

        ArgumentCaptor<ItemCarrito> itemCarritoArgumentCaptor = ArgumentCaptor.forClass(ItemCarrito.class);
        verify(carritoRepository).save(itemCarritoArgumentCaptor.capture());
        ItemCarrito savedItem = itemCarritoArgumentCaptor.getValue();
        assertNotNull(savedItem);
        assertEquals(producto.getId(), savedItem.getProducto().getId());
        assertEquals(USUARIO_NORMAL.getId(), savedItem.getUsuario().getId());
        assertEquals(10, savedItem.getCantidad());
    }

    @Test
    public void shouldUpdateExistingItem() {
        Producto producto = buildRandomProduct();
        ItemCarrito expectedItemCarrito = new ItemCarrito(producto, 10, USUARIO_NORMAL);
        when(carritoRepository.findByUsuarioAndProducto_IdAndOrdenIsNull(eq(USUARIO_NORMAL), eq(producto.getId())))
                .thenReturn(Optional.of(expectedItemCarrito));
        when(carritoRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);

        carritoService.addOrUpdate(producto.getId(), 50, USUARIO_NORMAL);

        verify(productoRepository, times(0)).findById(any());
        ArgumentCaptor<ItemCarrito> itemCarritoArgumentCaptor = ArgumentCaptor.forClass(ItemCarrito.class);
        verify(carritoRepository).save(itemCarritoArgumentCaptor.capture());
        ItemCarrito savedItem = itemCarritoArgumentCaptor.getValue();
        assertNotNull(savedItem);
        assertEquals(producto.getId(), savedItem.getProducto().getId());
        assertEquals(USUARIO_NORMAL.getId(), savedItem.getUsuario().getId());
        assertEquals(50, savedItem.getCantidad());
    }

    @Test
    public void shouldThrowWhenAddingInvalidProduct() {
        when(carritoRepository.findByUsuarioAndProducto_IdAndOrdenIsNull(eq(USUARIO_NORMAL), any()))
                .thenReturn(Optional.empty());
        when(productoRepository.findById(any())).thenReturn(Optional.empty());

        Producto producto = buildRandomProduct();
        assertThrows(IllegalArgumentException.class,
                () -> carritoService.addOrUpdate(producto.getId(), 10, USUARIO_NORMAL));
    }

    @Test
    public void shouldRemoveProduct() {
        long itemId = new Random().nextLong();
        carritoService.remove(itemId);
        verify(carritoRepository).deleteById(eq(itemId));
    }

    @Test
    public void shouldClear() {
        carritoService.clear(USUARIO_NORMAL);
        verify(carritoRepository).deleteAllByUsuarioAndOrdenIsNull(eq(USUARIO_NORMAL));
    }
}
