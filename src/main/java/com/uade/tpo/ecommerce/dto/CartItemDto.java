package com.uade.tpo.ecommerce.dto;

import com.uade.tpo.ecommerce.model.Product;

public class CartItemDto {
    private final Product product;
    private final int quantity;

    public CartItemDto(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
