package com.example.practise.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {

    private Long id;

    private String name;

    private Double cost;

    private Double price;

    private String brand;

    private String details;

    private Integer amount;

}