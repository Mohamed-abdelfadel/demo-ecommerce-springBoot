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
    @PutMapping("/{id}/activate")
    public Category activate(@PathVariable Long id) {
        return categoryService.activate(id) ;
    }
    @PutMapping("/{id}/deactivate")
    public Category deactivate(@PathVariable Long id) {
        return categoryService.deactivate(id) ;
    }
//    @GetMapping("/{id}")
//    public Category getCategory(@PathVariable Long id) {
//        return categoryService.getCategory(id);
//    }

//    @GetMapping("/activated")
//    public List<Category> getActivatedCategories() {
//        return categoryService.getActivatedCategories();
//    }

//    @GetMapping("/deactivated")
//    public List<Category> getDeactivatedCategories() {
//        return categoryService.getDeactivatedCategories();
//    }

//    @GetMapping("/{id}/products")
//    public List<Product> getProductsByCategoryId(@PathVariable Long id) {
//        return categoryService.getProductsByCategoryId(id);
//    }

//    @DeleteMapping("/{id}")
//    public void deleteCategory(@PathVariable Long id) {
//        categoryService.delete(id);
//    }
}

