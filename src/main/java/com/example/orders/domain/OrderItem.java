package com.example.orders.domain;

import jakarta.validation.constraints.*;

public class OrderItem {
    @NotBlank
    private String productId;

    @Min(value = 1, message = "Quantity must be positive")
    private int quantity;

    @DecimalMin(value = "0.01", message = "Price must be greater than zero")
    private double price;

    public OrderItem(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public double subtotal() {
        return quantity * price;
    }

    // getters omitted for brevity
}