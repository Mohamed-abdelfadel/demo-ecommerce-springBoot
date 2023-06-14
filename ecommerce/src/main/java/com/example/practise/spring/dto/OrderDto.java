package com.example.practise.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDto {

    private Long id;
    private Date date;
    private Boolean received;

}