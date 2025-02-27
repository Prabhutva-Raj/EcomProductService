package com.prabhu.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
