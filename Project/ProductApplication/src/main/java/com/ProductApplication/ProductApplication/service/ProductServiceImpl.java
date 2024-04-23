package com.ProductApplication.ProductApplication.service;

import com.ProductApplication.ProductApplication.domain.Product;
import com.ProductApplication.ProductApplication.dto.ProductDTO;
import com.ProductApplication.ProductApplication.mapper.ProductMapper;
import com.ProductApplication.ProductApplication.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ProductApplication.ProductApplication.mapper.ProductMapper.ProductDTOToProduct;
import static com.ProductApplication.ProductApplication.mapper.ProductMapper.ProductToProductDTO;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    private static final Logger LOG = LogManager.getLogger(ProductServiceImpl.class);

    private static long logId = 1;
    @Override
    public void createProduct(ProductDTO product) {
        Product existingProduct = productRepository.getProductByName(product.getProductName());
        if (existingProduct != null) {
            LOG.info("Adding Product Fail: Product already exists!", "P" + logId++);
            return;
        }
        LOG.info("Adding Product Success: " + product, "P" + logId++);
        productRepository.createProduct(ProductDTOToProduct(product));

    }

    @Override
    public void updateProduct(String productName, ProductDTO product) {
        Product existingProduct = productRepository.getProductByName(productName);
        if (existingProduct == null) {
            LOG.info("Updating Product Fail: Product does not exist!", "P" + logId++);
            return;
        }
        LOG.info("Updating Product Success: " + product, "P" + logId++);
        productRepository.updateProduct(ProductDTOToProduct(product));

    }

    @Override
    public void deleteProduct(String productName) {
        Product existingProduct = productRepository.getProductByName(productName);
        if (existingProduct == null) {
            LOG.info("Deleting Product Fail: Product does not exist!", "P" + logId++);
            return;
        }
        LOG.info("Deleting Product Success: " + existingProduct, "P" + logId++);
        productRepository.deleteProduct(existingProduct);

    }

    @Override
    public List<ProductDTO> getProducts() {
        return productRepository.getAllProducts().stream().map(ProductMapper::ProductToProductDTO).toList();
    }

    @Override
    public ProductDTO getProduct(String name) {
        return ProductToProductDTO(productRepository.getProductByName(name));
    }
}
