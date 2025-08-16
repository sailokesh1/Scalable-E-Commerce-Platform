package com.varunmatangi.order_service.controller;

import com.varunmatangi.order_service.dto.CreateOrderRequestDTO;
import com.varunmatangi.order_service.dto.OrderResponseDTO;
import com.varunmatangi.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/place-order")
    public OrderResponseDTO createOrder(@RequestBody CreateOrderRequestDTO orderRequest) {
        return orderService.createOrder(orderRequest);
    }

    // 2. Fetch single order
    @GetMapping("/{id}")
    public OrderResponseDTO getOrderById(@PathVariable UUID id) {
        return orderService.getOrderById(id);
    }

    // 3. Fetch all orders
    @GetMapping
    public List<OrderResponseDTO> getAllOrders() {
        return orderService.getAllOrders();
    }
}
