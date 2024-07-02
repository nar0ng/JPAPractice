package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
    List<Order> findAllByOrderStatus(OrderStatus orderStatus);
    List<Order> findAllByOrderStatusOrderByOrderDateTime(OrderStatus orderStatus);
}