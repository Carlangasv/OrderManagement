package com.example.finalproject.onlineordermanagement.services;

import com.example.finalproject.onlineordermanagement.models.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUserById(Long userId);

    User saveUser(User newUser);

    void removeUser(Long userId);
}

