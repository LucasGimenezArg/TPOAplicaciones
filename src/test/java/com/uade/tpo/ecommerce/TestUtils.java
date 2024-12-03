package com.uade.tpo.ecommerce;

import com.uade.tpo.ecommerce.model.Categoria;
import com.uade.tpo.ecommerce.model.Producto;
import com.uade.tpo.ecommerce.model.UsuarioNormal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class TestUtils {
    public static final UsuarioNormal USUARIO_NORMAL = new UsuarioNormal(
            "test", "test@test.com", "test", "Juan Carlos", "Test", new Date());

    public static Producto buildRandomProduct() {
        long randomId = new Random().nextLong();
        Categoria categoria = new Categoria(randomId, "Test category " + randomId, "Test" + randomId);
        return new Producto(randomId, "Test product " + randomId, 150, 1000, categoria, "Test info " + randomId, new ArrayList<>());
    }

    public static Producto buildPersistableProduct(Categoria categoria) {
        UUID uuid = UUID.randomUUID();
        return new Producto(null, "Test product " + uuid, 150, 1000, categoria, "Test info " + uuid, new ArrayList<>());
    }
}
