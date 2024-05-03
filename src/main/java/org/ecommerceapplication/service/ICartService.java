package org.ecommerceapplication.service;

import org.ecommerceapplication.model.Cart;
import org.ecommerceapplication.model.Product;

public interface ICartService {

    void addProduct(String userId, Product product);
    void removeProduct(String userId, String productId);
    void modifyProduct(String userId, String productId, int quantity);

    void clearCart(String userId);
    Cart getCart(String userId);
}


//add/remove/modify product items in their shopping cart.