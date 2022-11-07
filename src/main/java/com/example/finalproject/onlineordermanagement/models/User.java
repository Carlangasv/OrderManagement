package com.example.finalproject.onlineordermanagement.models;

import com.example.finalproject.onlineordermanagement.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private Long id;

    private String username;

    private String password;

    private String roles;

    @OneToMany(mappedBy = "owner", cascade = {CascadeType.ALL})
    private List<Order> orderList;
    public User(Long id) {
        this.id = id;
    }
}
