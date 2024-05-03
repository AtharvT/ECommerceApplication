package org.ecommerceapplication.concreteimpl;

import org.ecommerceapplication.model.Product;
import org.ecommerceapplication.service.IInventoryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Product Service can also be called Inventory Service

public class InventoryServiceImpl implements IInventoryService {

    private final Map<String, Product> productNameMap = new HashMap<>();
    private final Map<String, List<Product>> productCategoryMap = new HashMap<>();

    // This is basically like the inventory. Different from the cart
    @Override
    public void addProduct(Product product) {
        productNameMap.put(product.getProductName(), product);
        var list = productCategoryMap.getOrDefault(product.getCategory(), new ArrayList<>());
        list.add(product);
        productCategoryMap.put(product.getCategory(), list);
    }

    @Override
    public Product searchProductByName(String productName) {
        if(!productNameMap.containsKey(productName)) {
            System.out.println("Could not find any product for this name");
            return null;
        }

        System.out.println("Found the product with product name " + " " + productName);

        return productNameMap.get(productName);
    }

    @Override
    public List<Product> searchProductByCategory(String productCategory) {
        if(!productCategoryMap.containsKey(productCategory)) {
            System.out.println("Could not find any product for this name");
            return null;
        }

        System.out.println("Found the product with product category " + " " + productCategory);
        var list = productCategoryMap.get(productCategory);
        return list;
    }

    @Override
    public void updateProductQuantity(String productId, int quantityOrdered) {
        Product product = productNameMap.get(productId);
        if (product != null) {
            int currentQuantity = product.getQuantity();
            int newQuantity = currentQuantity - quantityOrdered;
            if (newQuantity >= 0) {
                product.setQuantity(newQuantity);
                // Update the product in the productNameMap and productCategoryMap
                productNameMap.put(productId, product);
                List<Product> products = productCategoryMap.get(product.getCategory());
                if (products != null) {
                    products.replaceAll(p -> p.getProductId().equals(productId) ? product : p);
                }
            } else {
                throw new IllegalArgumentException("Insufficient quantity in the inventory");
            }
        } else {
            throw new IllegalArgumentException("Product not found in the inventory");
        }
    }
}
