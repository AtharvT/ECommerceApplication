package org.ecommerceapplication.service;

import org.ecommerceapplication.model.Product;

import java.util.List;

public interface IInventoryService {
    void addProduct(Product product);
    Product searchProductByName(String productName);
    List<Product> searchProductByCategory(String productCategory);
    void updateProductQuantity(String productId, int quantityOrdered);
}
