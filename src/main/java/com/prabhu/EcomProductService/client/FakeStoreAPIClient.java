package com.prabhu.EcomProductService.client;

import com.prabhu.EcomProductService.dto.FakeStoreProductRequestDTO;
import com.prabhu.EcomProductService.dto.FakeStoreProductResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/*Kind of Wrapper on FakeStoreProduct APIs*/
@Component
public class FakeStoreAPIClient {
    private RestTemplateBuilder restTemplateBuilder;

    String fakeStoreAPIURL;

    @Value("${fakestore.api.path.product}")         //field injection used
    String fakeStoreAPIPathProduct;

    //Constructor
    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder,
                              @Value("${fakestore.api.url}") String fakeStoreAPIURL) {      //constructor injection
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIURL = fakeStoreAPIURL;
    }

    // Methods
    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO fakeStoreProductRequestDTO){
        String createProductUrl = fakeStoreAPIURL + fakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse = restTemplate.postForEntity(createProductUrl, fakeStoreProductRequestDTO, FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }

    public FakeStoreProductResponseDTO getProductById(int id){
        String getProductByIdUrl = fakeStoreAPIURL + fakeStoreAPIPathProduct + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> fakeStoreProductResponseDTO = restTemplate.getForEntity(getProductByIdUrl, FakeStoreProductResponseDTO.class);
        return fakeStoreProductResponseDTO.getBody();
    }

    public List<FakeStoreProductResponseDTO> getAllProducts(){
        String getAllProductsUrl = fakeStoreAPIURL + fakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();    //.build() to get the object from a builder
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseArray = restTemplate.getForEntity(getAllProductsUrl, FakeStoreProductResponseDTO[].class);

        return List.of(productResponseArray.getBody());
    }

    public void deleteProduct(int id){
        String productDeleteUrl = fakeStoreAPIURL + fakeStoreAPIPathProduct + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(productDeleteUrl);
    }

}