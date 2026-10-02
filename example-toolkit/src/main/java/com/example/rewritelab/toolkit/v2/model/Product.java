package com.example.rewritelab.toolkit.v2.model;

import lombok.With;

import java.math.BigDecimal;

/**
 * v2 Product — immutable record.
 *
 * <p>Migration notes from v1:
 * <ul>
 *   <li>No-arg constructor removed</li>
 *   <li>Price changed from double to BigDecimal</li>
 *   <li>Getters replaced by record accessors, e.g. {@code getName()} becomes {@code name()}</li>
 *   <li>Setters replaced by {@code withX} methods that return a modified copy</li>
 *   <li>{@code isSku(String)} renamed to {@code hasSku(String)}</li>
 * </ul>
 */
@With
public record Product(String sku, String name, BigDecimal price, int quantity) {

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
}
