package org.ecommerceapplication;

import org.ecommerceapplication.admin.Admin;
import org.ecommerceapplication.concreteimpl.*;
import org.ecommerceapplication.model.Product;
import org.ecommerceapplication.model.User;
import org.ecommerceapplication.model.UserRole;
import org.ecommerceapplication.service.*;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // Created 3 users
        User user = new User("1", "Atharva", UserRole.REGISTERED);
        User user2 = new User("2", "Tanmay", UserRole.REGISTERED);
        User user3 = new User("3", "Vigynesh", UserRole.GUEST);


        // Prepare the user map repository in the user service
        Map<String, User> userIdMap = new HashMap<>();

        userIdMap.put("1", user);
        userIdMap.put("2", user);
        userIdMap.put("3", user);

        IUserService userService = new UserServiceImpl(userIdMap);

        IInventoryService inventoryService = new InventoryServiceImpl();

        Product product1 = new Product("1", "iPhone 13 Pro", 999.99, "Apple's latest flagship smartphone", 100, "Electronics");
        Product product2 = new Product("2", "Nike Air Max 90", 119.99, "Classic sneakers with comfortable cushioning", 50, "Footwear");
        Product product3 = new Product("3", "Kindle Paperwhite", 129.99, "Waterproof e-reader with high-resolution display", 75, "Electronics");
        Product product4 = new Product("4", "Levi's 501 Original Fit Jeans", 69.99, "Classic straight leg jeans with button fly", 200, "Clothing");

        inventoryService.addProduct(product1);
        inventoryService.addProduct(product2);
        inventoryService.addProduct(product3);
        inventoryService.addProduct(product4);

        CartServiceImpl cartService = new CartServiceImpl();

        IPaymentService paymentService = new PaymentServiceImpl();

        INotificationService notificationService = new NotificationServiceImpl();
        IOrderService orderService = new OrderServiceImpl(cartService, inventoryService, paymentService, notificationService, new HashMap<>());
        IReviewService reviewService = new ReviewServiceImpl();
        IAddressService addressService = new AddressServiceImpl();
        Admin admin = new Admin(userService, paymentService, inventoryService, cartService, orderService, notificationService, reviewService, addressService);

        System.out.println("Adding a product to product inventory");
        Product product = new Product("3", "Kindle Paperwhite", 129.99, "Waterproof e-reader with high-resolution display", 75, "Electronics");
        admin.addProductToSell(product);

        System.out.println("Trying to search for a product by name Iphone13 pro");
        admin.searchProductByName("iPhone 13 Pro");


        System.out.println("Trying to search for a product by category Electronics");
        admin.searchProductByCategory("Electronics");

        System.out.println("Please add products to your cart");
        admin.addToCart(product, user);


        System.out.println("Please modify your product");






    }
}