package com.example.finalproject.onlineordermanagement.dtos;

import com.example.finalproject.onlineordermanagement.enums.UserType;
import com.example.finalproject.onlineordermanagement.models.Order;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("userType")
    private UserType userType;
}
