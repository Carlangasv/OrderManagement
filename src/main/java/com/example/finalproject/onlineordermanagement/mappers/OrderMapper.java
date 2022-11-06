package com.example.finalproject.onlineordermanagement.mappers;

import com.example.finalproject.onlineordermanagement.dtos.OrderDto;
import com.example.finalproject.onlineordermanagement.models.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface OrderMapper {
    OrderDto orderToOrderDto(Order order);
}
