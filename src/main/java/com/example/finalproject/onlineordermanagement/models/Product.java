package com.example.finalproject.onlineordermanagement.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Long price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Product(String name, Long price, Order order) {
        this.name = name;
        this.price = price;
        this.order = order;
    }
}
