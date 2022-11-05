package com.example.finalproject.onlineordermanagement.models;

import com.example.finalproject.onlineordermanagement.enums.UserType;
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

    private String name;

    private String email;

    private String password;

    @Enumerated(EnumType.ORDINAL)
    private UserType userType;

    @OneToMany(mappedBy = "owner")
    private List<Order> orderList;
}
