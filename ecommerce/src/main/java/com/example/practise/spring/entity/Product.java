package com.example.practise.spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double cost;

    private Double price;

    private String brand;

    private String details;

    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private Boolean activated = true;

}