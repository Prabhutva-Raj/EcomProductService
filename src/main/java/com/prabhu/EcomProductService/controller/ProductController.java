package com.prabhu.EcomProductService.controller;

import com.prabhu.EcomProductService.dto.ProductListResponseDTO;
import com.prabhu.EcomProductService.dto.ProductResponseDTO;
import com.prabhu.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    @Qualifier("fakeStoreProductService")       //used to identify between multiple implementations
    private ProductService productService;


    @GetMapping("/products")
    public ResponseEntity getAllProducts(){
        /*ProductResponseDTO p1 = new ProductResponseDTO();
        p1.setId(1);
        p1.setTitle("Iphone 15");
        p1.setPrice(150000);
        p1.setImage("");
        p1.setDescription("Iphone at best");
        p1.setCategory("Electronics");

        ProductResponseDTO p2 = new ProductResponseDTO();
        p2.setId(2);
        p2.setTitle("Macbook Pro");
        p2.setPrice(250000);
        p2.setImage("");
        p2.setDescription("Macbook at best");
        p2.setCategory("Electronics");

        List<ProductResponseDTO> products = Arrays.asList(p1, p2);

        return ResponseEntity.ok(products);*/

        ProductListResponseDTO response = productService.getAllProducts();
        return  ResponseEntity.ok(response);

    }

    @GetMapping("/products/1")
    public ResponseEntity getProductFromId(){
        ProductResponseDTO response = productService.getProductById(1);
        return ResponseEntity.ok(response);

    }
}
