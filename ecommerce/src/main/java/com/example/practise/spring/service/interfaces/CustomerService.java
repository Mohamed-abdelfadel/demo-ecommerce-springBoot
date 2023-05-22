package com.example.practise.spring.service.interfaces;

import com.example.practise.spring.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    Customer addCustomer(Customer customer);


}
