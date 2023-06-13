package com.example.practise.spring.service.interfaces;

import com.example.practise.spring.dto.OrderDto;
import com.example.practise.spring.entity.Item;
import com.example.practise.spring.entity.Order;
import com.example.practise.spring.entity.OrderStatus;
import com.example.practise.spring.entity.Product;

import java.util.List;

public interface OrderService {
    List<OrderDto> get();
    Order add(Order order);
    List<OrderDto> findByCustomerId(Long id);
    List<OrderDto> findByStatusId(Long id);
    List<Item> getItems(Long orderId);
    void addItem(Long orderId, Long productId,int amount);
    Order shipped(Long id);
    Order status(Long id , OrderStatus status);
    Order update(Long id , Order order);

}
