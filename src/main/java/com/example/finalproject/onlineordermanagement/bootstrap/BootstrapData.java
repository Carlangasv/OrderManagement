package com.example.finalproject.onlineordermanagement.bootstrap;

import com.example.finalproject.onlineordermanagement.enums.UserRole;
import com.example.finalproject.onlineordermanagement.models.Order;
import com.example.finalproject.onlineordermanagement.models.User;
import com.example.finalproject.onlineordermanagement.repositories.OrderRepository;
import com.example.finalproject.onlineordermanagement.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class BootstrapData implements CommandLineRunner {

    private final UserRepository userRepository;

    private final OrderRepository orderRepository;

    private final PasswordEncoder passwordEncoder;

    public BootstrapData(UserRepository userRepository, OrderRepository orderRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        User user = new User();
        Order order = new Order(new Date(), user);
        user.setUsername("Carlos");
        user.setRoles(UserRole.ROLE_USER.toString());
        user.setPassword(passwordEncoder.encode("test4echo"));
        user.setId(123L);
        user.setOrderList(new ArrayList<>(List.of(order)));
        userRepository.save(user);
        userRepository.save(new User(1234L
                , "User2"
                , passwordEncoder.encode("test4echo")
                , UserRole.ROLE_ADMIN.toString()
                , new ArrayList<>(List.of(order))));
        orderRepository.save(order);
    }
}
