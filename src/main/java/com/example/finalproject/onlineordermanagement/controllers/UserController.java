package com.example.finalproject.onlineordermanagement.controllers;

import com.example.finalproject.onlineordermanagement.dtos.UserDto;
import com.example.finalproject.onlineordermanagement.mappers.UserMapper;
import com.example.finalproject.onlineordermanagement.models.User;
import com.example.finalproject.onlineordermanagement.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<UserDto> getUsers(){
        return getUserService().getUsers().stream().map(userMapper::userToUserDto).toList();
    }

    public UserService getUserService() {
        return userService;
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }
}
