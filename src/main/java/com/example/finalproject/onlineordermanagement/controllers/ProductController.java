package com.example.finalproject.onlineordermanagement.controllers;

import com.example.finalproject.onlineordermanagement.models.Product;
import com.example.finalproject.onlineordermanagement.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable("productId") Long productId){
        return productService.getProductById(productId);
    }

    @RequestMapping("/name/{productName}")
    public Product getProductByName(@PathVariable("productName") String productName){
        return productService.getProductByName(productName);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{productId}")
    public void removeProduct(@PathVariable("productId") Long productId){
        productService.removeProduct(productId);
    }
}
