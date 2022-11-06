package com.example.finalproject.onlineordermanagement.services.impl;

import com.example.finalproject.onlineordermanagement.models.Order;
import com.example.finalproject.onlineordermanagement.repositories.OrderRepository;
import com.example.finalproject.onlineordermanagement.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DefaultOrderService implements OrderService {

    private final OrderRepository orderRepository;

    public DefaultOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Order saveOrder(Order newOrder) {
        return orderRepository.save(newOrder);
    }

    @Override
    public void removeOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
