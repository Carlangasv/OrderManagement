package com.example.finalproject.onlineordermanagement.controllers;

import com.example.finalproject.onlineordermanagement.dtos.ProductDto;
import com.example.finalproject.onlineordermanagement.mappers.ProductMapper;
import com.example.finalproject.onlineordermanagement.models.Product;
import com.example.finalproject.onlineordermanagement.services.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping
    public List<ProductDto> getProducts() {
        return productService.getProducts().stream().map(productMapper::productToProductDto).toList();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{productId}")
    public ProductDto getProductById(@PathVariable("productId") Long productId) {
        return productMapper.productToProductDto(productService.getProductById(productId));
    }

    @PostMapping
    public ProductDto saveProduct(@RequestBody Product product) {
        return productMapper.productToProductDto(productService.saveProduct(product));
    }
}
