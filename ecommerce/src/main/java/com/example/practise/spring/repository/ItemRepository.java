package com.example.practise.spring.repository;

import com.example.practise.spring.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

    List<Item> findByOrderId(Long orderId);
}
