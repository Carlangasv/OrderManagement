package com.example.finalproject.onlineordermanagement.repositories;

import com.example.finalproject.onlineordermanagement.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product getProductByName(String productName);
}
