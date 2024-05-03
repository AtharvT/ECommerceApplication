package org.ecommerceapplication.service;

import org.ecommerceapplication.exceptions.UserNotRegisteredException;
import org.ecommerceapplication.model.Cart;
import org.ecommerceapplication.model.Order;
import org.ecommerceapplication.model.User;

public interface IOrderService {
    Order createOrder(Cart cart, User user);
    void processOrder(Order order) throws UserNotRegisteredException;
    void cancelOrder(String orderId);
}
