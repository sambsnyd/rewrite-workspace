package com.example.rewritelab.toolkit.v1.model;

import java.math.BigDecimal;

/**
 * A product JavaBean POJO.
 */
public class Product {

    private String sku;
    private String name;
    private BigDecimal price;
    private int quantity;

    public Product() {
    }

    public Product(String sku, String name, BigDecimal price, int quantity) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // SimplifyTernary
    public boolean isInStock() {
        return quantity > 0 ? true : false;
    }

    // EqualsAvoidsNull
    public boolean isSku(String value) {
        return sku.equals(value);
    }

    public BigDecimal totalValue() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    @Override
    public String toString() {
        return "Product{sku='" + sku + "', name='" + name + "', price=" + price + ", qty=" + quantity + "}";
    }
}
