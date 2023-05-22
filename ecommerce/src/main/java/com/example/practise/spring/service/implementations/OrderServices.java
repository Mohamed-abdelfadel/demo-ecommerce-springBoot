package com.example.practise.spring.service.implementations;

import com.example.practise.spring.dto.OrderDto;
import com.example.practise.spring.entity.Order;
import com.example.practise.spring.entity.OrderStatus;
import com.example.practise.spring.entity.Product;
import com.example.practise.spring.repository.OrderRepository;
import com.example.practise.spring.repository.ProductRepository;
import com.example.practise.spring.service.interfaces.OrderService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServices implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderServices(OrderRepository orderRepository, ProductService productService, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }
    public List<OrderDto> get(){
        return orderRepository.findOrders();
    }
    public Order add(Order order){
        return orderRepository.save(order);
    }
    public List<OrderDto>findByCustomerId(Long id){
        return orderRepository.findByCustomerId(id);
    }
    public List<OrderDto>findByStatusId(Long id){
        return orderRepository.findByStatusId(id);
    }

    public Order getOrderWithProducts(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow();
    }

    public void addProductsToOrder(Long orderId, Long productId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalOrder.isPresent() && optionalProduct.isPresent()) {
            Order order = optionalOrder.get();
            Product product = optionalProduct.get();

            order.getProducts().add(product);
            product.getOrders().add(order);

            orderRepository.save(order);
            productRepository.save(product);
        }
    }

    public Order shipped(Long id) {
        Order order = orderRepository.findById(id).orElseThrow();
        order.setReceived(true);
        return orderRepository.save(order);
    }
    public Order status(Long id , OrderStatus status){
        Order order = orderRepository.findById(id).orElseThrow();
        order.setStatus(status);
        return orderRepository.save(order);
    }
    public Order update(Long id , Order order){
        Order existingOrder = orderRepository.findById(id).orElseThrow();
        if (order.getCustomer() != null) {
            existingOrder.setCustomer(order.getCustomer());
        }
        if (order.getStatus() != null) {
            existingOrder.setStatus(order.getStatus());
        }
        if (order.getReceived() != null) {
            existingOrder.setReceived(order.getReceived());
        }
        if (order.getDate() != null) {
            existingOrder.setDate(order.getDate());
        }
        return orderRepository.save(existingOrder);
    }

}

