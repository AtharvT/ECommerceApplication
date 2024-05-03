package org.ecommerceapplication.admin;

import org.ecommerceapplication.model.Product;
import org.ecommerceapplication.model.User;
import org.ecommerceapplication.service.*;

import java.util.List;

public class Admin {
    private final IUserService userService;
    private final IPaymentService paymentService;
    private final IInventoryService inventoryService;
    private final ICartService cartService;
    private final IOrderService orderService;
    private final INotificationService notificationService;
    private final IReviewService reviewService;
    private final IAddressService addressService;


    public Admin(IUserService userService, IPaymentService paymentService, IInventoryService inventoryService, ICartService cartService, IOrderService orderService, INotificationService notificationService, IReviewService reviewService, IAddressService addressService) {
        this.userService = userService;
        this.paymentService = paymentService;
        this.inventoryService = inventoryService;
        this.cartService = cartService;
        this.orderService = orderService;
        this.notificationService = notificationService;
        this.reviewService = reviewService;
        this.addressService = addressService;
    }

    public void addProductToSell(Product product) {
        inventoryService.addProduct(product);
    }

    public List<Product> searchProductByCategory(String category) {
        return inventoryService.searchProductByCategory(category);
    }

    public Product searchProductByName(String productName) {
        return inventoryService.searchProductByName(productName);
    }

    public void addToCart(Product product, User user) {
        cartService.addProduct(user.getUserId(), product);
    }

}
