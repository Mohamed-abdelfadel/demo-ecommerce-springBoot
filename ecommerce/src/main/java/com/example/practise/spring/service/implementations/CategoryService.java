package com.example.practise.spring.service.implementations;
import com.example.practise.spring.entity.Category;
import com.example.practise.spring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements com.example.practise.spring.service.interfaces.CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> get() {
        return categoryRepository.findByActivatedTrue();
    }

    public Category add(Category category) {
        return categoryRepository.save(category);
    }
    public Category update(Long productId, Category category) {
        Category existingCategory = categoryRepository.findById(productId).orElseThrow();
        if (category.getName() != null) {
            existingCategory.setName(category.getName());
        }
        if (category.getDetails() != null) {
            existingCategory.setDetails(category.getDetails());
        }
        if (category.getActivated() != null) {
            existingCategory.setActivated(category.getActivated());
        }
        return categoryRepository.save(existingCategory);
    }
    public Category activate(Long id) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow();
        existingCategory.setActivated(true);
        return categoryRepository.save(existingCategory);
    }
    public Category deactivate(Long id) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow();
        existingCategory.setActivated(false);
        return categoryRepository.save(existingCategory);
    }
    //    public Category getCategory(Long id) {
//        return categoryRepository.findById(id).orElseThrow();
//    }

//    public List<Category> getActivatedCategories() {
//        return categoryRepository.findByActivatedTrue();
//    }

//    public List<Category> getDeactivatedCategories() {
//        return categoryRepository.findByActivatedFalse();
//    }

//    public List<Product> getProductsByCategoryId(Long id) {
//        return categoryRepository.findProductsById(id);
//    }

//    public void delete(Long id) {
//        categoryRepository.deleteById(id);
//    }

}
