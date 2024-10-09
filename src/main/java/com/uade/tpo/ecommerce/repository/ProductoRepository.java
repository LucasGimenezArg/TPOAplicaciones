package com.uade.tpo.ecommerce.repository;


import com.uade.tpo.ecommerce.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uade.tpo.ecommerce.model.Producto;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByCategoria(Categoria categoria);

    @Query("SELECT p " +
            "FROM Producto p " +
            "JOIN ItemCarrito ic ON p.id = ic.producto.id " +
            "JOIN Orden o ON ic.orden.id = o.id " +
            "GROUP BY p.id ")
    List<Producto> findTopTen();
}
