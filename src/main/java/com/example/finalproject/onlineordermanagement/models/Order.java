package com.example.finalproject.onlineordermanagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date creationDate;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    private User owner;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Product> productList;

    public Order(Date creationDate, User owner) {
        this.creationDate = creationDate;
        this.owner = owner;
    }
}
