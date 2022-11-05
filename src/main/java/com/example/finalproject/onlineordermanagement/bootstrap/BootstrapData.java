package com.example.finalproject.onlineordermanagement.bootstrap;

import com.example.finalproject.onlineordermanagement.enums.UserType;
import com.example.finalproject.onlineordermanagement.models.Order;
import com.example.finalproject.onlineordermanagement.models.User;
import com.example.finalproject.onlineordermanagement.repositories.OrderRepository;
import com.example.finalproject.onlineordermanagement.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class BootstrapData implements CommandLineRunner {

    private final UserRepository userRepository;

    private final OrderRepository orderRepository;

    public BootstrapData(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args){
        User user = new User();
        Order order = new Order(new Date(), user);
        user.setName("Carlos");
        user.setUserType(UserType.user);
        user.setPassword("12345");
        user.setEmail("carlos@carlos.com");
        user.setId(123L);
        user.setOrderList(new ArrayList<>(List.of(order)));
        userRepository.save(user);
        orderRepository.save(order);
    }
}
