package com.example.practise.spring.controller;

import com.example.practise.spring.entity.Category;
import com.example.practise.spring.service.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService ;
    @GetMapping
    public List<Category> get() {
        return categoryService.get();
    }
    @PostMapping
    public Category add(@RequestBody Category category) {
        return categoryService.add(category);
    }
    @PutMapping("/{id}")
    public Category update(@PathVariable Long id,@RequestBody Category category) {
        return categoryService.update(id,category);
    }
    @PutMapping("/{id}/activation")
    public Category activation(@PathVariable Long id,@RequestParam Boolean activate){
        return categoryService.activation(id,activate);
    }

}

