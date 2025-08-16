package com.varunmatangi.product_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    private String errorCode;
    private String errorMessage;
    private Instant timestamp;
}
