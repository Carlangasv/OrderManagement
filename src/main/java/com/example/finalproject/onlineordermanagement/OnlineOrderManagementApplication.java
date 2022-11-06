package com.example.finalproject.onlineordermanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class OnlineOrderManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(OnlineOrderManagementApplication.class, args);
    }
}
