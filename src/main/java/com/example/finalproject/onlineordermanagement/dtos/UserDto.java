package com.example.finalproject.onlineordermanagement.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    @JsonProperty("userName")
    private String username;

    @JsonProperty("userRole")
    private String roles;

    @JsonProperty("orderList")
    private List<OrderDto> orderList;
}
