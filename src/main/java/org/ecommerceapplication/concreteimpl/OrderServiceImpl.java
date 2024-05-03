package org.ecommerceapplication.concreteimpl;

import org.ecommerceapplication.exceptions.UserNotRegisteredException;
import org.ecommerceapplication.model.*;
import org.ecommerceapplication.service.*;

import java.util.Map;

public class OrderServiceImpl implements IOrderService {

    private final ICartService cartService;
    private final IInventoryService inventoryService;
    private final IPaymentService paymentService;
    private final INotificationService notificationService;
    private final Map<String, Order> orderIdMap;

    public OrderServiceImpl(ICartService cartService, IInventoryService inventoryService, IPaymentService paymentService, INotificationService notificationService, Map<String, Order> orderIdMap) {
        this.cartService = cartService;
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
        this.notificationService = notificationService;
        this.orderIdMap = orderIdMap;
    }

    @Override
    public Order createOrder(Cart cart, User user) {
        var order = new Order(user, cart.getProductList());
        orderIdMap.put(order.getOrderId(), order);
        return order;
    }

    @Override
    public void processOrder(Order order) throws UserNotRegisteredException {

        User user = order.getUser();
        if (user.isRegistered()) {
            for (Product product : order.getProducts()) {
                inventoryService.updateProductQuantity(product.getProductId(), product.getQuantity());
            }

            paymentService.processPayment(order.getTotalAmount());
            order.setStatus(OrderStatus.PROCESSING);
            cartService.clearCart(order.getUser().getUserId());
            notificationService.sendOrderConfirmation(order);
        } else {
            throw new UserNotRegisteredException("This user cannot buy an item as it is not registered");
        }
    }

    @Override
    public void cancelOrder(String orderId) {
        Order order = getOrderById(orderId);
        if (order != null && order.getStatus() != OrderStatus.SHIPPED) {
            order.setStatus(OrderStatus.CANCELLED);
        }
    }

    private Order getOrderById(String orderId) {
        return orderIdMap.get(orderId);
    }
}
