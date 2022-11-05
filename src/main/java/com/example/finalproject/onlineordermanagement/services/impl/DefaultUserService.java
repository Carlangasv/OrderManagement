package com.example.finalproject.onlineordermanagement.services.impl;

import com.example.finalproject.onlineordermanagement.models.User;
import com.example.finalproject.onlineordermanagement.repositories.UserRepository;
import com.example.finalproject.onlineordermanagement.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return getUserRepository().findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return getUserRepository().findById(userId).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User getUserByEmail(String email) {
        return getUserRepository().findUserByEmail(email);
    }

    @Override
    public User saveUser(User newUser) {
        return getUserRepository().save(newUser);
    }

    @Override
    public void removeUser(Long userId) {
        getUserRepository().deleteById(userId);
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
