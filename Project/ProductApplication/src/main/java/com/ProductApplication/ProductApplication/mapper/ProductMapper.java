package com.ProductApplication.ProductApplication.mapper;

import com.ProductApplication.ProductApplication.domain.Product;
import com.ProductApplication.ProductApplication.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public static ProductDTO ProductToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getId());
        productDTO.setProductName(product.getProductName());
        productDTO.setProductDescription(product.getProductDescription());
        productDTO.setProductPrice(product.getProductPrice());
        return productDTO;
    }

    public static Product ProductDTOToProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductDescription(productDTO.getProductDescription());
        product.setProductPrice(productDTO.getProductPrice());
        product.setProductName(productDTO.getProductName());
        return product;
    }
}
