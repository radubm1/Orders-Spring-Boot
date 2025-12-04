package com.example.orders.domain;

import jakarta.validation.constraints.*;
import java.util.List;

public class Order {
    @NotBlank
    private String orderId;

    @NotNull
    private Customer customer;

    @Size(max = 10, message = "Cannot have more than 10 items in an order")
    private List<OrderItem> items;

    public Order(String orderId, Customer customer, List<OrderItem> items) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = items;
    }

    public double totalPrice() {
        return items.stream().mapToDouble(OrderItem::subtotal).sum();
    }

    @AssertTrue(message = "Order total must be at least 20 EUR")
    public boolean isValidTotal() {
        return totalPrice() >= 20.0;
    }

	public String getOrderId() {
		return orderId;
	}

    // getters omitted for brevity
}