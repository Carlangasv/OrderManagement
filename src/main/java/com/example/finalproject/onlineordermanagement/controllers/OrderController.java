package com.example.finalproject.onlineordermanagement.controllers;

import com.example.finalproject.onlineordermanagement.dtos.OrderDto;
import com.example.finalproject.onlineordermanagement.mappers.OrderMapper;
import com.example.finalproject.onlineordermanagement.models.Order;
import com.example.finalproject.onlineordermanagement.models.SecurityUser;
import com.example.finalproject.onlineordermanagement.services.OrderService;
import com.example.finalproject.onlineordermanagement.services.UserService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CacheConfig(cacheNames = {"orders"})
public class OrderController {

    private final OrderService orderService;

    private final OrderMapper orderMapper;


    private final UserService userService;

    public OrderController(OrderService orderService, OrderMapper orderMapper, UserService userService) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.userService = userService;

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    @Cacheable
    public ResponseEntity<?> getOrders() {
        return ResponseEntity.ok(orderService.getOrders().stream().map(orderMapper::orderToOrderDto).toList());
    }

    @GetMapping("/my-orders")
    @CachePut
    public List<OrderDto> getOrderById() {
        SecurityUser securityUser = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.getUserById(securityUser.getId()).getOrderList().stream().map(orderMapper::orderToOrderDto).toList();
    }

    @PostMapping
    @CacheEvict(value = "addresses", allEntries = true)
    public OrderDto saveOrder(@RequestBody Order order) {
        return orderMapper.orderToOrderDto(orderService.saveOrder(order));
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable("orderId") Long orderId) {
        orderService.removeOrder(orderId);
    }
}

