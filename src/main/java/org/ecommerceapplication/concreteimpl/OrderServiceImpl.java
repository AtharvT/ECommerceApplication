package org.ecommerceapplication.concreteimpl;

import org.ecommerceapplication.exceptions.UserNotRegisteredException;
import org.ecommerceapplication.model.*;
import org.ecommerceapplication.service.*;

public class OrderServiceImpl implements IOrderService {

    private final ICartService cartService;
    private final IInventoryService inventoryService;
    private final IPaymentService paymentService;
    private final INotificationService notificationService;

    public OrderServiceImpl(ICartService cartService, IInventoryService inventoryService, IPaymentService paymentService, INotificationService notificationService) {
        this.cartService = cartService;
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
        this.notificationService = notificationService;
    }

    @Override
    public Order createOrder(Cart cart, User user) {
        return new Order(user, cart.getProductList());
    }

    @Override
    public void processOrder(Order order) throws UserNotRegisteredException {

        User user = order.getUser();
        if (user.isRegistered()) {
            for (Product product : order.getProducts()) {
                inventoryService.updateProductQuantity(product.getProductId(), product.getQuantity());
            }

            paymentService.processPayment(order.getTotalAmount());
            order.setStatus(OrderStatus.IN_PROGRESS);
            cartService.clearCart(order.getUser().getUserId());
            notificationService.sendOrderConfirmation(order);
        } else {
           throw new UserNotRegisteredException("This user cannot buy an item as it is not registered");
        }
    }
}
