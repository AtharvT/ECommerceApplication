package org.ecommerceapplication.model;

public class Product {
    private final String productId;
    private final String productName;
    private final double price;
    private final String description;
    private int quantity;
    private final String category;


    public Product(String productId, String productName, Double price, String description, int quantity, String category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public String getProductId() {
        return productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
