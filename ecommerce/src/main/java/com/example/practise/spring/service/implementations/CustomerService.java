package com.example.practise.spring.service;

import com.example.practise.spring.entity.Customer;
import com.example.practise.spring.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Customerservice{

    private final CustomerRepository customerRepository;

    public Customerservice(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


}
