package org.ecommerceapplication.concreteimpl;

import org.ecommerceapplication.model.Cart;
import org.ecommerceapplication.model.Product;
import org.ecommerceapplication.service.ICartService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CartServiceImpl implements ICartService {
    private Map<String, Cart> userCartMap;

    public CartServiceImpl() {
        this.userCartMap = new HashMap<>();
    }

    @Override
    public void addProduct(String userId, Product product) {
        Cart cart = userCartMap.getOrDefault(userId, new Cart(new ArrayList<>()));
        cart.getProductList().add(product);
        userCartMap.put(userId, cart);
        System.out.println("Successfully added your product to the cart for User " + userId);
    }

    @Override
    public void removeProduct(String userId, String productId) {
        Cart cart = userCartMap.get(userId);
        if (cart != null) {
            cart.getProductList().removeIf(product -> product.getProductId().equals(productId));
        }
    }

    @Override
    public void modifyProduct(String userId, String productId, int quantity) {
        Cart cart = userCartMap.get(userId);
        if (cart != null) {
            for (Product product : cart.getProductList()) {
                if (product.getProductId().equals(productId)) {
                    product.setQuantity(quantity);
                    break;
                }
            }
        }
    }

    @Override
    public Cart getCart(String userId) {
        return userCartMap.get(userId);
    }

    @Override
    public void clearCart(String userId) {
        userCartMap.remove(userId);
    }
}