package com.example.finalproject.onlineordermanagement.services.impl;

import com.example.finalproject.onlineordermanagement.models.Order;
import com.example.finalproject.onlineordermanagement.models.Product;
import com.example.finalproject.onlineordermanagement.models.SecurityUser;
import com.example.finalproject.onlineordermanagement.repositories.OrderRepository;
import com.example.finalproject.onlineordermanagement.services.OrderService;
import com.example.finalproject.onlineordermanagement.services.ProductService;
import com.example.finalproject.onlineordermanagement.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DefaultOrderService implements OrderService {

    private final OrderRepository orderRepository;

    private final UserService userService;


    public DefaultOrderService(OrderRepository orderRepository, UserService userService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
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
        if (newOrder.getOwner() == null) {
            SecurityUser securityUser = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            newOrder.setOwner(userService.getUserById(securityUser.getId()));
        }
        if(newOrder.getCreationDate() == null){
            newOrder.setCreationDate(new Date());
        }
        return orderRepository.save(newOrder);
    }

    @Override
    public void removeOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
