package com.example.practise.spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private Boolean received;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
