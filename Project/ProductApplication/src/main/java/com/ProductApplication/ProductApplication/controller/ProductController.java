package com.ProductApplication.ProductApplication.controller;

import com.ProductApplication.ProductApplication.dto.ProductDTO;
import com.ProductApplication.ProductApplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{productName}")
    public ProductDTO getProductByProductName(@PathVariable String productName) {
        return productService.getProduct(productName);
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody ProductDTO productDTO) {
        productService.createProduct(productDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{productName}")
    public ResponseEntity<?> updateProduct(@PathVariable String productName, @RequestBody ProductDTO productDTO) {
        productService.updateProduct(productName, productDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{productName}")
    public ResponseEntity<?> deleteProduct(@PathVariable String productName) {
        productService.deleteProduct(productName);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
