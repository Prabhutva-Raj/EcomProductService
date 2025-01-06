package com.prabhu.EcomProductService.service;

import com.prabhu.EcomProductService.client.FakeStoreAPIClient;
import com.prabhu.EcomProductService.dto.*;
import com.prabhu.EcomProductService.exception.ProductNotFoundException;
import com.prabhu.EcomProductService.mapper.ProductMapper;
import com.prabhu.EcomProductService.model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.prabhu.EcomProductService.mapper.ProductMapper.convertFakeProductResponseToProductResponse;
import static com.prabhu.EcomProductService.mapper.ProductMapper.convertProductRequestToFakeStoreProductRequest;
import static com.prabhu.EcomProductService.utils.ProductUtil.isNull;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreAPIClient fakeStoreAPIClient;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder, FakeStoreAPIClient fakeStoreAPIClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }


    @Override
    public ProductListResponseDTO getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProductResponseDTOList = fakeStoreAPIClient.getAllProducts();

        ProductListResponseDTO productResponseList = new ProductListResponseDTO();
        for(FakeStoreProductResponseDTO product : fakeStoreProductResponseDTOList) {
            productResponseList.getProducts().add(convertFakeProductResponseToProductResponse(product));
        }

        return productResponseList;
    }

    @Override
    public ProductResponseDTO getProductById(int id) throws ProductNotFoundException {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.getProductById(id);
        if(isNull(fakeStoreProductResponseDTO))
        {
            throw new ProductNotFoundException("Product not found with id: "+id);
        }
        return convertFakeProductResponseToProductResponse(fakeStoreProductResponseDTO);
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = ProductMapper.convertProductRequestToFakeStoreProductRequest(productRequestDTO);
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.createProduct(fakeStoreProductRequestDTO);

        return convertFakeProductResponseToProductResponse(fakeStoreProductResponseDTO);
    }

    @Override
    public boolean deleteProduct(int id) {
        fakeStoreAPIClient.deleteProduct(id);
        return true;
    }

    @Override
    public Product updateProduct(int id, Product updatedProduct) {
        return null;
    }
}
