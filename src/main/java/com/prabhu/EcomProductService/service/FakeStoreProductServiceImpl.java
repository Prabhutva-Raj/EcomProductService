package com.prabhu.EcomProductService.service;

import com.prabhu.EcomProductService.dto.ProductListResponseDTO;
import com.prabhu.EcomProductService.dto.ProductRequestDTO;
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
        ResponseEntity<ProductResponseDTO[]> productResponseArray = restTemplate.getForEntity(getAllProductsUrl, ProductResponseDTO[].class);

        ProductListResponseDTO productResponseList = new ProductListResponseDTO();
        for(ProductResponseDTO product : productResponseArray.getBody()) {   //'productResponse. getBody()' may produce 'NullPointerException'
            productResponseList.getProducts().add(product);
            //note .getProducts() gets you the 'product' attribute/object, of ProductListResponseDTO, which is private and can't be used directly.
        }

        return productResponseList;
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        String getProductByIdUrl = ("https://fakestoreapi.com/products/"+id);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> productResponse = restTemplate.getForEntity(getProductByIdUrl, ProductResponseDTO.class);
        return productResponse.getBody();
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        String createProductUrl = "https://fakestoreapi.com/products";
        /*RestTemplateBuilder restTemplate = new RestTemplateBuilder();
        ResponseEntity<ProductResponseDTO> productResponse = restTemplate.build().postForEntity(createProductUrl, productRequestDTO, ProductResponseDTO.class);
        return productResponse.getBody();*/
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> productResponse = restTemplate.postForEntity(createProductUrl, productRequestDTO, ProductResponseDTO.class);
        return productResponse.getBody();
    }

    @Override
    public boolean deleteProduct(int id) {
        String productDeleteUrl = "https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(productDeleteUrl);          //returns void; raises exception if anything wrong.
        return true;
    }

    @Override
    public Product updateProduct(int id, Product updatedProduct) {
        return null;
    }
}
