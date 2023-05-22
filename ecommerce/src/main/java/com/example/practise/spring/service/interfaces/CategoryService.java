package com.example.practise.spring.service.interfaces;

import com.example.practise.spring.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> get();
    Category add(Category category);
    Category update(Long productId, Category category);
    Category activate(Long id);
    Category deactivate(Long id);
}
