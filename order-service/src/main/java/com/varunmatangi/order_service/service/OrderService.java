package com.varunmatangi.order_service.service;

import com.varunmatangi.order_service.dto.CreateOrderRequestDTO;
import com.varunmatangi.order_service.dto.OrderResponseDTO;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    OrderResponseDTO createOrder(CreateOrderRequestDTO orderRequest);

    OrderResponseDTO getOrderById(UUID id);

    List<OrderResponseDTO> getAllOrders();
}
