package com.example.finalproject.onlineordermanagement.mappers;

import com.example.finalproject.onlineordermanagement.dtos.ProductDto;
import com.example.finalproject.onlineordermanagement.models.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ProductMapper {
    ProductDto productToProductDto(Product product);
}
