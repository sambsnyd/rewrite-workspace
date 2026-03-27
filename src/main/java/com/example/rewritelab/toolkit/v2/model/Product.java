package com.example.rewritelab.toolkit.v2.model;

import java.math.BigDecimal;

/**
 * v2 Product — fluent setters, factory method, no no-arg constructor.
 *
 * <p>Migration notes from v1:
 * <ul>
 *   <li>No-arg constructor removed; use {@link #of(String, String, BigDecimal, int)}</li>
 *   <li>Setters now return {@code this} for fluent chaining</li>
 *   <li>{@code isSku(String)} renamed to {@code hasSku(String)}</li>
 * </ul>
 */
public class Product {

    private final String sku;
    private String name;
    private BigDecimal price;
    private int quantity;

    public Product(String sku, String name, BigDecimal price, int quantity) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public static Product of(String sku, String name, BigDecimal price, int quantity) {
        return new Product(sku, name, price, quantity);
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    /** Fluent setter — returns {@code this}. */
    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    /** Fluent setter — returns {@code this}. */
    public Product setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    /** Fluent setter — returns {@code this}. */
    public Product setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public boolean isInStock() {
        return quantity > 0;
    }

    /** Renamed from v1 {@code isSku}. */
    public boolean hasSku(String value) {
        return sku != null && sku.equals(value);
    }

    public BigDecimal totalValue() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    @Override
    public String toString() {
        return "Product{sku='" + sku + "', name='" + name + "', price=" + price + ", qty=" + quantity + "}";
    }
}
