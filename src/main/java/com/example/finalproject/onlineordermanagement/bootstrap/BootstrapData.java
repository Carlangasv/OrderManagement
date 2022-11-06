package com.example.finalproject.onlineordermanagement.bootstrap;

import com.example.finalproject.onlineordermanagement.enums.UserRole;
import com.example.finalproject.onlineordermanagement.models.Order;
import com.example.finalproject.onlineordermanagement.models.Product;
import com.example.finalproject.onlineordermanagement.models.User;
import com.example.finalproject.onlineordermanagement.repositories.OrderRepository;
import com.example.finalproject.onlineordermanagement.repositories.ProductRepository;
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
    private final ProductRepository productRepository;

    private final PasswordEncoder passwordEncoder;

    public BootstrapData(UserRepository userRepository, OrderRepository orderRepository,
                         ProductRepository productRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        createData();
    }

    private void createData() {
        User user = new User();
        Order order = new Order(new Date(), user);
        user.setUsername("User");
        user.setRoles(UserRole.ROLE_USER.toString());
        user.setPassword(passwordEncoder.encode("test4echo"));
        user.setId(123L);
        user.setOrderList(new ArrayList<>(List.of(order)));

        User user2 = new User();
        Order order2 = new Order(new Date(), user2);
        user2.setUsername("Admin");
        user2.setRoles(UserRole.ROLE_ADMIN.toString());
        user2.setPassword(passwordEncoder.encode("test4echo"));
        user2.setId(1234L);
        user2.setOrderList(new ArrayList<>(List.of(order2)));

        Product product1 = new Product("Bicicleta", 10000L, order);
        Product product2 = new Product("Bicicleta2", 20000L, order);
        Product product3 = new Product("Bicicleta", 10000L, order2);
        Product product4 = new Product("Bicicleta2", 20000L, order2);
        order.setProductList(new ArrayList<>(List.of(product1, product2)));
        order2.setProductList(new ArrayList<>(List.of(product3, product4)));
        userRepository.save(user);
        userRepository.save(user2);
    }

}
