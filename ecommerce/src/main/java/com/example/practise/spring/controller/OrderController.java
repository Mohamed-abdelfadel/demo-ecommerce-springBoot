package com.example.practise.spring.controller;

import com.example.practise.spring.dto.OrderDto;
import com.example.practise.spring.entity.Order;
import com.example.practise.spring.service.OrderServices;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderServices orderServices;

    @GetMapping
    public List<Order> get(){
        return orderServices.get();
    }
    @PostMapping
    public Order add(@RequestBody Order order){
        return orderServices.add(order);
    }

    @GetMapping("/customer/{id}")
    public List<OrderDto> findByCustomerId(@PathVariable Long id){
        return orderServices.findByCustomerId(id);
    }
    @GetMapping("/status/{id}")
    public List<OrderDto> findByStatusId(@PathVariable Long id){
        return orderServices.findByStatusId(id);
    }

    @GetMapping("/{id}")
    public Order getOrderWithProducts(@PathVariable Long id) {
        return orderServices.getOrderWithProducts(id);
    }


    @PostMapping("/{orderId}/product/{productId}")
    public void addProductsToOrder(@PathVariable Long orderId, @PathVariable Long productId) {
        orderServices.addProductsToOrder(orderId, productId);
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable Long id ,@RequestBody Order order){
        return orderServices.update(id,order);
    }
    @PutMapping("/{id}/shipped")
    public Order shipped(@PathVariable Long id){
        return orderServices.shipped(id);
    }
}
