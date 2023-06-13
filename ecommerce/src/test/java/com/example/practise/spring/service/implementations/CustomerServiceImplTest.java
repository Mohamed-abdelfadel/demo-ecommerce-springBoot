package com.example.practise.spring.service.implementations;

import com.example.practise.spring.entity.Customer;
import com.example.practise.spring.repository.AddressRepository;
import com.example.practise.spring.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class CustomerServiceImplTest {
    @Autowired
    private CustomerRepository customerRepository;
    private CustomerServiceImpl underTest;

    @BeforeEach
    void setUp() {
        customerRepository = Mockito.mock(CustomerRepository.class);
        underTest = new CustomerServiceImpl(customerRepository);
    }
    @Test
    public void testGetCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1L, "Mohamed yasser", "mohamed@gmail.com", "01121118319"));
        customers.add(new Customer(2L, "Mohamed yasser", "mohamed2@gmail.com", "01121118319"));

        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> result = underTest.getCustomers();
        assertEquals(customers, result);
    }

    @Test
    public void testAddCustomer() {
        Customer customer = new Customer(1L, "Mohamed yasser", "mohamed@gmail.com", "01121118319");

        when(customerRepository.save(customer)).thenReturn(customer);

        Customer result = underTest.addCustomer(customer);
        assertEquals(customer, result);
    }
}