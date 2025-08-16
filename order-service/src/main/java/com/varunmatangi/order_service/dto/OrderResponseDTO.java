package com.varunmatangi.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {
    private String orderId;
    private String orderStatus;
    private Double totalAmount;
    private List<OrderItemResponse> orderItems;
}
