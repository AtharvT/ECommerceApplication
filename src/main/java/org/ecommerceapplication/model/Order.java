package org.ecommerceapplication.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private String orderId;
    private User user;
    private List<Product> products;
    private double totalAmount;
    private OrderStatus status;
    private LocalDateTime orderDate;
    private String shippingAddress;

    public Order(User user, List<Product> products) {
        this.orderId = generateOrderId();
        this.user = user;
        this.products = products;
        this.totalAmount = calculateTotalAmount();
        this.status = OrderStatus.PENDING;
        this.orderDate = LocalDateTime.now();
    }

    // Getter and Setter methods
    public String getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    // Other methods
    private String generateOrderId() {
        return "ORD" + System.currentTimeMillis() + user.getUserId();
    }

    private double calculateTotalAmount() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }
}