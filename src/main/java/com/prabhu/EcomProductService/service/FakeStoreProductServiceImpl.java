package com.prabhu.EcomProductService.service;

import com.prabhu.EcomProductService.dto.ProductListResponseDTO;
import com.prabhu.EcomProductService.dto.ProductResponseDTO;
import com.prabhu.EcomProductService.model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        String getAllProductsUrl = ("https://fakestoreapi.com/products");
        RestTemplate restTemplate = restTemplateBuilder.build();    //.build() to get the object from a builder
        ResponseEntity<ProductListResponseDTO> productResponse = restTemplate.getForEntity(getAllProductsUrl, ProductListResponseDTO.class);
        return productResponse.getBody();
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        String getProductByIdUrl = ("https://fakestoreapi.com/products/1");
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> productResponse = restTemplate.getForEntity(getProductByIdUrl, ProductResponseDTO.class);
        return productResponse.getBody();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(int id) {
        return null;
    }

    @Override
    public Product updateProduct(int id, Product updatedProduct) {
        return null;
    }
}
