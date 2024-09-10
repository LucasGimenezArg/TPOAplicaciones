package com.uade.tpo.ecommerce.controller;

import com.uade.tpo.ecommerce.dto.CartItemDto;
import com.uade.tpo.ecommerce.service.CartService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/cart", consumes = "application/json", produces = "application/json")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public Collection<CartItemDto> list() {
        return cartService.getAll().stream()
                .map(item -> new CartItemDto(item.getProduct(), item.getQuantity().intValue()))
                .collect(Collectors.toList());
    }

    @PostMapping("/producto")
    public void addProduct(CartItemDto cartItem) {
        cartService.addOrUpdate(cartItem.getProduct(), cartItem.getQuantity());
    }

    @DeleteMapping("/producto")
    public void removeProduct(Long productId) {
        cartService.remove(productId);
    }

    @DeleteMapping
    public void clear() {
        cartService.clear();
    }

    @PostMapping("/checkout")
    public void checkout() {

    }
}
