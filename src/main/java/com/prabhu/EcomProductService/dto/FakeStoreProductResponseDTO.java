package com.prabhu.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductResponseDTO {          //creating a DTO specifically for 3rd party.
    private int id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
