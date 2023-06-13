package com.example.practise.spring.service.implementations;

import com.example.practise.spring.dto.OrderDto;
import com.example.practise.spring.entity.Item;
import com.example.practise.spring.entity.Order;
import com.example.practise.spring.entity.OrderStatus;
import com.example.practise.spring.repository.ItemRepository;
import com.example.practise.spring.repository.OrderRepository;
import com.example.practise.spring.repository.ProductRepository;
import com.example.practise.spring.service.interfaces.OrderService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServicesImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    private final ItemRepository itemRepository;



    public OrderServicesImpl(OrderRepository orderRepository, ProductRepository productRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.itemRepository = itemRepository;
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

    public List<Item>  getItems(Long orderId) {
        return itemRepository.findByOrderId(orderId);
    }
    public void addItem(Long orderId, Long productId,int amount) {
        var item = new Item();
        item.setOrder(orderRepository.findById(orderId).orElseThrow());
        item.setProduct(productRepository.findById(productId).orElseThrow());
        item.setAmount(amount);
        itemRepository.save(item);
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

