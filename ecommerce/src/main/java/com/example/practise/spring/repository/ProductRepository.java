package com.example.practise.spring.repository;

import com.example.practise.spring.dto.ProductDto;
import com.example.practise.spring.entity.Category;
import com.example.practise.spring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product , Long> {
    List<Product> findAllByPriceBetween(Double minPrice, Double maxPrice);
    @Query("SELECT new com.example.practise.spring.dto.ProductDto(p.id, p.name, p.cost, p.price, p.brand, p.details, p.amount) FROM Product p WHERE p.category.id = :id")
    List<ProductDto> findByCategoryId(@Param("id") Long id);
}
