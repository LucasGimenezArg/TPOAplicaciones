package com.uade.tpo.ecommerce.repository;

import com.uade.tpo.ecommerce.model.ItemCarrito;
import com.uade.tpo.ecommerce.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface CarritoRepository extends JpaRepository<ItemCarrito, Long> {
    Collection<ItemCarrito> findAllByUsuarioAndOrdenIsNull(Usuario usuario);
    Optional<ItemCarrito> findByUsuarioAndProducto_IdAndOrdenIsNull(Usuario usuario, Long productoId);
    void deleteAllByUsuarioAndOrdenIsNull(Usuario usuario);
}
