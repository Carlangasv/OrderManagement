package com.example.finalproject.onlineordermanagement.services;

import com.example.finalproject.onlineordermanagement.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProductById(Long productId);

    Product saveProduct(Product newProduct);
}
