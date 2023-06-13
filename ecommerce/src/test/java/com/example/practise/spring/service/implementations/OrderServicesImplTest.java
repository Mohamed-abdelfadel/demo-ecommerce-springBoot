//package com.example.practise.spring.service.implementations;
//
//import com.example.practise.spring.entity.Order;
//import com.example.practise.spring.repository.*;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import static org.junit.jupiter.api.Assertions.*;
//import com.example.practise.spring.entity.Customer;
//import com.example.practise.spring.repository.CustomerRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class OrderServicesImplTest {
//    @Autowired
//    private OrderRepository orderRepository;
//    @Autowired
//    private ProductRepository productRepository;
//    private OrderServicesImpl underTest;
//
//    @BeforeEach
//    void setUp() {
//        orderRepository = Mockito.mock(OrderRepository.class);
//        productRepository = Mockito.mock(ProductRepository.class);
//        underTest = new OrderServicesImpl(orderRepository,productRepository);
//    }
//    @Test
//    void get() {
//        List<Order> orders = new ArrayList<>();
//        orders.add(new Order(1L, "Mohamed yasser", "mohamed@gmail.com", "01121118319"));
//        orders.add(new Order(2L, "Mohamed yasser", "mohamed2@gmail.com", "01121118319"));
//
//        when(customerRepository.findAll()).thenReturn(customers);
//    }
//
//    @Test
//    void add() {
//    }
//
//    @Test
//    void findByCustomerId() {
//    }
//
//    @Test
//    void findByStatusId() {
//    }
//
//    @Test
//    void getOrderWithProducts() {
//    }
//
//    @Test
//    void addProductsToOrder() {
//    }
//
//    @Test
//    void shipped() {
//    }
//
//    @Test
//    void status() {
//    }
//
//    @Test
//    void update() {
//    }
//}