package com.example.practise.spring.service;

import com.example.practise.spring.entity.Address;
import com.example.practise.spring.entity.Customer;
import com.example.practise.spring.entity.Order;
import com.example.practise.spring.entity.Product;
import com.example.practise.spring.repository.AddressRepository;
import com.example.practise.spring.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Customerservice{

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;

    public Customerservice(CustomerRepository customerRepository, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


}
