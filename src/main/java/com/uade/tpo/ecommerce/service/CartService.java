package com.uade.tpo.ecommerce.service;

import com.uade.tpo.ecommerce.model.CartItem;
import com.uade.tpo.ecommerce.model.Product;

import java.util.Collection;

public interface CartService {
    Collection<CartItem> getAll();
    CartItem addOrUpdate(Product product, int quantity);
    void remove(Long productId);
    void clear();
}
