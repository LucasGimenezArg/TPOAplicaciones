package com.uade.tpo.ecommerce.model;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class CartItem {
    private final Product product;
    private final AtomicInteger quantity;

    public CartItem(Product product, int quantity) {
        Objects.requireNonNull(product);
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.product = product;
        this.quantity = new AtomicInteger(quantity);
    }

    public Product getProduct() {
        return product;
    }

    public AtomicInteger getQuantity() {
        return quantity;
    }
}
