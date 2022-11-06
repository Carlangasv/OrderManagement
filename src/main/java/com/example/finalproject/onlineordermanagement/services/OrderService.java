package com.example.finalproject.onlineordermanagement.services;

import com.example.finalproject.onlineordermanagement.models.Order;

import java.util.List;

public interface OrderService {

    List<Order> getOrders();

    Order getOrderById(Long orderId);

    Order saveOrder(Order newOrder);

    void removeOrder(Long orderId);
}
