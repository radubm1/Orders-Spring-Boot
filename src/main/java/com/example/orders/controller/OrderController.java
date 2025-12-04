package com.example.orders.controller;

import com.example.orders.domain.Order;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@GetMapping("/test")
	public String testOrder() {
	    return "Orders endpoint is alive!";
	}


    @PostMapping
    public String createOrder(@Valid @RequestBody Order order) {
        // If validation passes, business logic continues
        return "Order accepted: " + order.getOrderId();
    }
}