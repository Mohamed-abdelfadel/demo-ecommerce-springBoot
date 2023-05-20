package com.example.practise.spring.controller;

import com.example.practise.spring.entity.Address;
import com.example.practise.spring.entity.Customer;
import com.example.practise.spring.service.Customerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private Customerservice customerservice;
    @GetMapping
    public List<Customer> getCustomers(){
        return customerservice.getCustomers();
    }
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customerservice.addCustomer(customer);
    }


}
