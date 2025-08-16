package com.varunmatangi.order_service.aop;

import com.varunmatangi.order_service.dto.ExceptionResponse;
import com.varunmatangi.order_service.exception.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ExceptionResponse> orderNotFoundExceptionHandler(OrderNotFoundException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.errorCode, ex.getMessage(), Instant.now()), HttpStatus.NOT_FOUND);
    }
}
