package com.varunmatangi.order_service.service;

import com.varunmatangi.order_service.dto.CreateOrderRequestDTO;
import com.varunmatangi.order_service.dto.OrderItemRequest;
import com.varunmatangi.order_service.dto.OrderResponseDTO;
import com.varunmatangi.order_service.dto.ProductResponseDTO;
import com.varunmatangi.order_service.entity.Order;
import com.varunmatangi.order_service.entity.OrderItem;
import com.varunmatangi.order_service.mapper.OrderMapper;
import com.varunmatangi.order_service.repository.OrderRepo;
import com.varunmatangi.order_service.service.http.ProductHttpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepository;
    private final OrderMapper orderMapper;
    private final ProductHttpClient httpClient;

    public OrderResponseDTO createOrder(CreateOrderRequestDTO request) {
        Order order = orderMapper.toEntity(request);

        List<OrderItem> items = new ArrayList<>();
        double total = 0.0;

        for (OrderItemRequest itemReq : request.getItems()) {
            ProductResponseDTO product = httpClient.getProductById(itemReq.getProductId());
            OrderItem item = orderMapper.toEntity(itemReq);
            item.setOrder(order);
            total += item.getSubtotal();
            items.add(item);

            if(product.getProductStock()>= item.getQuantity()) {
                httpClient.reduceStock(item.getProductId(), item.getQuantity());
                order.setOrderStatus("PLACED");
            }else {
                order.setOrderStatus("PENDING");
            }
        }

        order.setOrderItems(items);
        order.setTotalAmount(total);

        Order saved = orderRepository.save(order);
        return orderMapper.toResponse(saved);
    }

    public OrderResponseDTO getOrderById(UUID orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
        return orderMapper.toResponse(order);
    }

    public List<OrderResponseDTO> getAllOrders() {
        return orderMapper.toResponseList(orderRepository.findAll());
    }
}
