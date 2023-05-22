package com.example.practise.spring.service.interfaces;

import com.example.practise.spring.dto.OrderDto;
import com.example.practise.spring.entity.Order;
import com.example.practise.spring.entity.OrderStatus;
import java.util.List;

public interface OrderService {
    List<OrderDto> get();
    Order add(Order order);
    List<OrderDto> findByCustomerId(Long id);
    List<OrderDto> findByStatusId(Long id);
    Order getOrderWithProducts(Long orderId);
    void addProductsToOrder(Long orderId, Long productId);
    Order shipped(Long id);
    Order status(Long id , OrderStatus status);
    Order update(Long id , Order order);

}
