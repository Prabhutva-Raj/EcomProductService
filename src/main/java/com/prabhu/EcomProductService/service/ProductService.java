package com.prabhu.EcomProductService.service;

import com.prabhu.EcomProductService.dto.ProductListResponseDTO;
import com.prabhu.EcomProductService.dto.ProductRequestDTO;
import com.prabhu.EcomProductService.dto.ProductResponseDTO;
import com.prabhu.EcomProductService.model.Product;

import java.util.List;

public interface ProductService {
    ProductListResponseDTO getAllProducts();
    ProductResponseDTO getProductById(int id);
    ProductResponseDTO createProduct(ProductRequestDTO product);
    boolean deleteProduct(int id);
    Product updateProduct(int id, Product updatedProduct);
}
