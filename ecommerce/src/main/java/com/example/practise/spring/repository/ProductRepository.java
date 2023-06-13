package com.example.practise.spring.repository;

import com.example.practise.spring.dto.ProductDto;
import com.example.practise.spring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product , Long> {

    @Query("SELECT new com.example.practise.spring.dto.ProductDto(p.id, p.name, p.price, p.brand, p.details, p.stock) FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    List<ProductDto> findAllByPriceBetween(Double minPrice, Double maxPrice);

    @Query("SELECT new com.example.practise.spring.dto.ProductDto(p.id, p.name, p.price, p.brand, p.details, p.stock) FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice AND p.category.id = :id")
    List<ProductDto> getProductsByCategoriesAndPrices(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice, @Param("id") Long categoryId);
    @Query("SELECT new com.example.practise.spring.dto.ProductDto(p.id, p.name, p.price, p.brand, p.details, p.stock) FROM Product p WHERE p.category.id = :id")
    List<ProductDto> findByCategoryId(@Param("id") Long id);
    @Query("SELECT new com.example.practise.spring.dto.ProductDto(p.id, p.name, p.price, p.brand, p.details, p.stock) FROM Product p WHERE p.activated = true AND p.category.activated = true")
    List<ProductDto> findByActivatedTrueAndCategoryActivatedTrue();}
