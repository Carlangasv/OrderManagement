package com.example.finalproject.onlineordermanagement.repositories;

import com.example.finalproject.onlineordermanagement.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
