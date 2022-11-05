package com.example.finalproject.onlineordermanagement.repositories;

import com.example.finalproject.onlineordermanagement.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
}
