package com.ProductApplication.ProductApplication.service;

import com.ProductApplication.ProductApplication.domain.Product;
import com.ProductApplication.ProductApplication.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    void createProduct(ProductDTO product);

    void updateProduct(String productName, ProductDTO product);

    void deleteProduct(String productName);

    List<ProductDTO> getProducts();

    ProductDTO getProduct(String productName);
}
