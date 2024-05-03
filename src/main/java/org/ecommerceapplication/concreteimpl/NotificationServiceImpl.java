package org.ecommerceapplication.concreteimpl;

import org.ecommerceapplication.model.Order;
import org.ecommerceapplication.service.INotificationService;

public class NotificationServiceImpl implements INotificationService {
    @Override
    public void sendOrderConfirmation(Order order) {
        System.out.println("Sent order confirmation");
        return;
    }

    @Override
    public void sendOrderStatusUpdate(Order order) {
            System.out.println("Sent order status update");
    }
}
