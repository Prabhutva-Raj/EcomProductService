package com.prabhu.EcomProductService.exception;

public class ProductNotFoundException extends Exception{

    //constructors
    public ProductNotFoundException() {
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
