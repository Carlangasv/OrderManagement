package com.example.finalproject.onlineordermanagement.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDto {

    @JsonProperty("userName")
    private String username;

    @JsonProperty("userRole")
    private String roles;

}
