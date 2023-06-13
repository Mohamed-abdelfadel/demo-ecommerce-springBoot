package com.example.practise.spring.service.interfaces;

import com.example.practise.spring.dto.ProductDto;
import com.example.practise.spring.entity.Product;
import java.util.List;

public interface ProductService {
    List<ProductDto> get();
    Product add(Long id, Product product);
    Product update(Long productId, Product product);
    Product activation(Long id, Boolean activate);
    List<ProductDto> priceBetween(Double minValue , Double maxValue);
    List<ProductDto> getProductsByCategoriesAndPrices(Double minValue, Double maxValue, Long categoryId);
    List<ProductDto> getAllProductsByCategoryId(Long categoryId);
}
