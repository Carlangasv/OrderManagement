package com.example.finalproject.onlineordermanagement.repositories;

import com.example.finalproject.onlineordermanagement.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
}
