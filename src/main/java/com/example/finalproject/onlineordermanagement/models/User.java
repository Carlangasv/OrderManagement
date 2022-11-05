package com.example.finalproject.onlineordermanagement.models;

import com.example.finalproject.onlineordermanagement.enums.UserType;
import jakarta.persistence.*;

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

    public User(){
        
    }
    public User(Long id, String name, String email, String password, UserType userType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.userType = userType;
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
}
