package com.example.finalproject.onlineordermanagement.models;

import com.example.finalproject.onlineordermanagement.enums.UserType;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    private Long id;

    private String name;

    private String email;

    private String password;

    @Enumerated(EnumType.ORDINAL)
    private UserType userType;

    @OneToMany(mappedBy = "user")
    private List<Order> orderList;

    public User(){
        
    }
    
    public User(Long id, String name, String email, String password, UserType userType, List<Order> orderList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.orderList = orderList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
