package com.varunmatangi.product_service.exception;

public class ProductNotFoundException extends RuntimeException {
    public String errorCode;

    public ProductNotFoundException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
