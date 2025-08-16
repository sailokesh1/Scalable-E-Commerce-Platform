package com.varunmatangi.order_service.repository;

import com.varunmatangi.order_service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepo extends JpaRepository<Order, UUID> {
}
