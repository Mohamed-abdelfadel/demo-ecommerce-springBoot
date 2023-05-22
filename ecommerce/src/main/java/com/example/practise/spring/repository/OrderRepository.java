package com.example.practise.spring.repository;

import com.example.practise.spring.dto.AddressDto;
import com.example.practise.spring.dto.OrderDto;
import com.example.practise.spring.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query("SELECT new com.example.practise.spring.dto.OrderDto(o.id, o.date, o.received) FROM Order o")
    List<OrderDto> findOrders();
    @Query("SELECT new com.example.practise.spring.dto.OrderDto(o.id, o.date, o.received) FROM Order o WHERE o.customer.id = :id")
    List<OrderDto> findByCustomerId(@Param("id") Long id);
    @Query("SELECT new com.example.practise.spring.dto.OrderDto(o.id, o.date, o.received) FROM Order o WHERE o.status.id = :id")
    List<OrderDto> findByStatusId(@Param("id") Long id);
}

