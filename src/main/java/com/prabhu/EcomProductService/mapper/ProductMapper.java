package com.prabhu.EcomProductService.mapper;

import com.prabhu.EcomProductService.dto.FakeStoreProductRequestDTO;
import com.prabhu.EcomProductService.dto.FakeStoreProductResponseDTO;
import com.prabhu.EcomProductService.dto.ProductRequestDTO;
import com.prabhu.EcomProductService.dto.ProductResponseDTO;

//conversion of objects
public class ProductMapper {            //static, can be called with ClassName directly.
    public static FakeStoreProductRequestDTO convertProductRequestToFakeStoreProductRequest(ProductRequestDTO productRequestDTO){

        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = new FakeStoreProductRequestDTO();

        fakeStoreProductRequestDTO.setCategory(productRequestDTO.getCategory());
        fakeStoreProductRequestDTO.setDescription(productRequestDTO.getDescription());
        fakeStoreProductRequestDTO.setTitle(productRequestDTO.getTitle());
        fakeStoreProductRequestDTO.setPrice(productRequestDTO.getPrice());
        fakeStoreProductRequestDTO.setImage(productRequestDTO.getImage());

        return fakeStoreProductRequestDTO;
    }


    public static ProductResponseDTO convertFakeProductResponseToProductResponse(FakeStoreProductResponseDTO fakeStoreProductResponseDTO){

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();

        productResponseDTO.setCategory(fakeStoreProductResponseDTO.getCategory());
        productResponseDTO.setDescription(fakeStoreProductResponseDTO.getDescription());
        productResponseDTO.setTitle(fakeStoreProductResponseDTO.getTitle());
        productResponseDTO.setPrice(fakeStoreProductResponseDTO.getPrice());
        productResponseDTO.setImage(fakeStoreProductResponseDTO.getImage());
        productResponseDTO.setId(fakeStoreProductResponseDTO.getId());

        return productResponseDTO;
    }
}
