package com.uade.tpo.ecommerce.service;

import com.uade.tpo.ecommerce.dto.OrdenDto;
import com.uade.tpo.ecommerce.dto.PageDto;
import com.uade.tpo.ecommerce.model.ItemCarrito;
import com.uade.tpo.ecommerce.model.Orden;
import com.uade.tpo.ecommerce.repository.CarritoRepository;
import com.uade.tpo.ecommerce.repository.OrdenRepository;
import com.uade.tpo.ecommerce.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.uade.tpo.ecommerce.TestUtils.USUARIO_NORMAL;
import static com.uade.tpo.ecommerce.TestUtils.buildRandomProduct;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OrdenServiceTest {
    private OrdenService ordenService;
    private CarritoRepository carritoRepository;
    private OrdenRepository ordenRepository;

    @BeforeEach
    public void setUp() {
        carritoRepository = mock(CarritoRepository.class);
        ordenRepository = mock(OrdenRepository.class);
        ordenService = new OrdenService(carritoRepository, mock(ProductoRepository.class), ordenRepository);
    }

    @Test
    public void shouldGetPreviousCheckouts() {
        PageImpl<Orden> page = new PageImpl<>(List.of(new Orden(USUARIO_NORMAL, LocalDateTime.now(), List.of())));
        when(ordenRepository.findAllByUsuario(any(), any())).thenReturn(page);
        PageDto<OrdenDto> pastOrdenes = ordenService.getPastOrdenes(USUARIO_NORMAL, 0, 10);
        verify(ordenRepository).findAllByUsuario(eq(USUARIO_NORMAL), eq(PageRequest.of(0, 10, Sort.by("fecha").descending())));
        assertNotNull(pastOrdenes);
        assertFalse(pastOrdenes.getItems().isEmpty());
    }

    @Test
    public void shouldCheckout() {
        List<ItemCarrito> expectedItems = List.of(new ItemCarrito(buildRandomProduct(), 10, USUARIO_NORMAL),
                new ItemCarrito(buildRandomProduct(), 20, USUARIO_NORMAL),
                new ItemCarrito(buildRandomProduct(), 30, USUARIO_NORMAL));
        Double expectedTotal = expectedItems.stream()
                .map(item -> item.getProducto().getPrecio() * item.getCantidad())
                .reduce(Double::sum)
                .orElse(-1D);
        when(carritoRepository.findAllByUsuarioAndOrdenIsNull(eq(USUARIO_NORMAL))).thenReturn(expectedItems);

        Optional<OrdenDto> result = ordenService.checkout(USUARIO_NORMAL);

        verify(ordenRepository).save(any());
        assertFalse(result.isEmpty());
        assertEquals(LocalDate.now(), result.get().getFecha().toLocalDate());
        assertTrue(result.get().getTotal() > 0);
        assertEquals(expectedTotal, result.get().getTotal());
        assertEquals(expectedItems.size(), result.get().getItems().size());
    }
}
