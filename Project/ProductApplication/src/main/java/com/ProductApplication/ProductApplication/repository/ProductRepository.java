package com.ProductApplication.ProductApplication.repository;

import com.ProductApplication.ProductApplication.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {
    private final Map<String, Product> products = new HashMap<>();

    public void createProduct(Product product) {
        products.put(product.getProductName().toUpperCase(), product);
    }

    public void updateProduct(Product product) {
        products.put(product.getProductName().toUpperCase(), product);
    }

    public void deleteProduct(Product product) {
        products.remove(product.getProductName().toUpperCase());
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    public Product getProductByName(String name) {
        return products.get(name.toUpperCase());
    }
}
