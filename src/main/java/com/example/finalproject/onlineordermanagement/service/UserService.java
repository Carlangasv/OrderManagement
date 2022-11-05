package com.example.finalproject.onlineordermanagement.service;

import com.example.finalproject.onlineordermanagement.models.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUserById(Long userId);

    User getUserByEmail(String email);

    User saveUser(User newUser);

    void removeUser(Long userId);
}

