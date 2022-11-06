package com.example.finalproject.onlineordermanagement.controllers;

import com.example.finalproject.onlineordermanagement.dtos.OrderDto;
import com.example.finalproject.onlineordermanagement.mappers.OrderMapper;
import com.example.finalproject.onlineordermanagement.models.Order;
import com.example.finalproject.onlineordermanagement.services.OrderService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CacheConfig(cacheNames = {"orders"})
public class OrderController {

    private final OrderService orderService;

    private final OrderMapper orderMapper;

    public OrderController(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    @Cacheable
    public List<OrderDto> getOrders() {
        return orderService.getOrders().stream().map(orderMapper::orderToOrderDto).toList();
    }

    @GetMapping("/{orderId}")
    @Cacheable
    public OrderDto getOrderById(@PathVariable("orderId") Long orderId) {
        return orderMapper.orderToOrderDto(orderService.getOrderById(orderId));
    }

    @PostMapping
    @CacheEvict(value="addresses", allEntries=true)
    public OrderDto saveOrder(@RequestBody Order order) {
        return orderMapper.orderToOrderDto(orderService.saveOrder(order));
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable("orderId") Long orderId) {
        orderService.removeOrder(orderId);
    }
}

