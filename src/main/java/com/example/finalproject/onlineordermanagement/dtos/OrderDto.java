package com.example.finalproject.onlineordermanagement.dtos;

import com.example.finalproject.onlineordermanagement.models.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("creationDate")
    private Date creationDate;

    @JsonProperty("products")
    private List<ProductDto> productList;
}
