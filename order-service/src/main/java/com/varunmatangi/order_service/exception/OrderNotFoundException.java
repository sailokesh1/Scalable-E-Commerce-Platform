package com.varunmatangi.order_service.exception;

import lombok.Data;

public class OrderNotFoundException extends RuntimeException {
    public String errorCode;

    public OrderNotFoundException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
