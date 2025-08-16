package com.varunmatangi.order_service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponse {
    private String orderItemId;
    private String productId;
    private Integer quantity;
    private Double price;
    private Double subtotal;
}
