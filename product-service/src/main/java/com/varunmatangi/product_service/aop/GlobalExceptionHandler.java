package com.varunmatangi.product_service.aop;

import com.varunmatangi.product_service.dto.ExceptionResponse;
import com.varunmatangi.product_service.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionResponse> productNotFoundException(ProductNotFoundException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.errorCode, ex.getMessage(), Instant.now()), HttpStatus.NOT_FOUND);
    }
}
