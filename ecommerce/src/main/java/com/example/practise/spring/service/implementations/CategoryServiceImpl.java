package com.example.practise.spring.service.implementations;
import com.example.practise.spring.entity.Category;
import com.example.practise.spring.repository.CategoryRepository;
import com.example.practise.spring.service.interfaces.CategoryService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Service
public class CategoryServiceImpl implements com.example.practise.spring.service.interfaces.CategoryService {
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    void get() {
        // Arrange
        List<Category> expectedCategories = new ArrayList<>();
        Category category1 = new Category();
        category1.setId(1L);
        category1.setName("Test Category 1");
        Category category2 = new Category();
        category2.setId(2L);
        category2.setName("Test Category 2");
        expectedCategories.add(category1);
        expectedCategories.add(category2);

        // Mock the categoryRepository
        Mockito.when(categoryRepository.findByActivatedTrue()).thenReturn(expectedCategories);

        // Act
        List<Category> actualCategories = categoryService.get();

        // Assert
        assertEquals(expectedCategories.size(), actualCategories.size());
        assertEquals(expectedCategories.get(0).getId(), actualCategories.get(0).getId());
        assertEquals(expectedCategories.get(0).getName(), actualCategories.get(0).getName());
        assertEquals(expectedCategories.get(1).getId(), actualCategories.get(1).getId());
        assertEquals(expectedCategories.get(1).getName(), actualCategories.get(1).getName());
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
