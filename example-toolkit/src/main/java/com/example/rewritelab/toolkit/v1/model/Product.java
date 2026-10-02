package com.example.rewritelab.toolkit.v1.model;

/**
 * A product JavaBean POJO.
 */
public class Product {

    private String sku;
    private String name;
    private double price;
    private int quantity;

    public Product() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
        return quantity > 0;
    }

    // EqualsAvoidsNull
    public boolean isSku(String value) {
        return sku.equals(value);
    }

    public double totalValue() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "Product{sku='" + sku + "', name='" + name + "', price=" + price + ", qty=" + quantity + "}";
    }
}
