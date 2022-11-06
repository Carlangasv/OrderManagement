package com.example.finalproject.onlineordermanagement.controllers;

import com.example.finalproject.onlineordermanagement.dtos.ProductDto;
import com.example.finalproject.onlineordermanagement.mappers.ProductMapper;
import com.example.finalproject.onlineordermanagement.models.Product;
import com.example.finalproject.onlineordermanagement.services.ProductService;
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

    @GetMapping
    public List<ProductDto> getProducts() {
        return productService.getProducts().stream().map(productMapper::productToProductDto).toList();
    }

    @GetMapping("/{productId}")
    public ProductDto getProductById(@PathVariable("productId") Long productId) {
        return productMapper.productToProductDto(productService.getProductById(productId));
    }

    @RequestMapping("/name/{productName}")
    public ProductDto getProductByName(@PathVariable("productName") String productName) {
        return productMapper.productToProductDto(productService.getProductByName(productName));
    }

    @PostMapping
    public ProductDto saveProduct(@RequestBody Product product) {
        return productMapper.productToProductDto(productService.saveProduct(product));
    }

    @DeleteMapping("/{productId}")
    public void removeProduct(@PathVariable("productId") Long productId) {
        productService.removeProduct(productId);
    }
}
