package org.ecommerceapplication.service;

import org.ecommerceapplication.model.Order;

public interface INotificationService {
    void sendOrderConfirmation(Order order);
    void sendOrderStatusUpdate(Order order);
}