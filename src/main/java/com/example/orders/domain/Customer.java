package com.example.orders.domain;

import jakarta.validation.constraints.*;

public class Customer {
    @NotBlank
    private String name;

    @Email
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // getters omitted for brevity
}