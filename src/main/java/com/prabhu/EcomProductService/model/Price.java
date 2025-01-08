package com.prabhu.EcomProductService.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Price {
    private String currency;
    private double amount;
    private double discount;
}
