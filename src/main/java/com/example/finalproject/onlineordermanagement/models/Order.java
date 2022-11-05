package com.example.finalproject.onlineordermanagement.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;
}
