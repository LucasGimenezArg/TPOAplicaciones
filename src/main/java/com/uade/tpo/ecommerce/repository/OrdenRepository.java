package com.uade.tpo.ecommerce.repository;

import com.uade.tpo.ecommerce.model.Orden;
import com.uade.tpo.ecommerce.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {
    List<Orden> findAllByUsuario(Usuario usuario);
}