package org.ecommerceapplication.model;

import java.util.List;

public class Cart {
    private final List<Product> productList;

    public Cart(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }
}
