package com.uade.tpo.ecommerce.service;

import com.uade.tpo.ecommerce.model.ItemCarrito;
import com.uade.tpo.ecommerce.dto.OrdenDto;
import com.uade.tpo.ecommerce.dto.PerfilDto;
import com.uade.tpo.ecommerce.model.Orden;
import com.uade.tpo.ecommerce.model.Usuario;
import com.uade.tpo.ecommerce.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerfilService {
    private final OrdenRepository ordenRepository;

    @Autowired
    public PerfilService(OrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

    public PerfilDto obtenerPerfil(Usuario usuario) {
        List<Orden> ordenes = ordenRepository.findAllByUsuario(usuario);

        List<OrdenDto> ordenDtos = ordenes.stream()
                .map(orden -> new OrdenDto(orden.getId(), orden.getFecha(), orden.getItems().stream()
                        .map(ItemCarrito::toDto)
                        .collect(Collectors.toList()), calcularTotal(orden)))
                .collect(Collectors.toList());

        return new PerfilDto(usuario.getNombre(), usuario.getApellido(), usuario.getMail(), ordenDtos);
    }

    private double calcularTotal(Orden orden) {
        return orden.getItems().stream()
                .mapToDouble(item -> item.getProducto().getPrecio() * item.getCantidad())
                .sum();
    }
}