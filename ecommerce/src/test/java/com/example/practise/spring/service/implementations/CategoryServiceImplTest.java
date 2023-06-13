package com.example.practise.spring.service.implementations;



import com.example.practise.spring.entity.Category;
import com.example.practise.spring.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {
    @Autowired
    private CategoryRepository categoryRepository;
    private CategoryServiceImpl underTest;

    @BeforeEach
    void setUp() {
        categoryRepository = Mockito.mock(CategoryRepository.class);
        underTest = new CategoryServiceImpl(categoryRepository);
    }

    @Test
    public void testGet() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1L, "Category 1", "Category 1 details", true));
        categories.add(new Category(2L, "Category 2", "Category 2 details", true));
        when(categoryRepository.findByActivatedTrue()).thenReturn(categories);
        List<Category> foundCategories = underTest.get();
        verify(categoryRepository).findByActivatedTrue();
        assertEquals(categories, foundCategories);
    }
    @Test
    public void testAdd() {
        Category category = new Category(1L, "Category 1", "Category 1 details", true);
        when(categoryRepository.save(category)).thenReturn(category);
        Category savedCategory = underTest.add(category);
        verify(categoryRepository).save(category);
        assertEquals(category, savedCategory);
    }
    @Test
    public void testUpdate() {
        Category existingCategory = new Category(1L, "Category 1", "Category 1 details", true);
        Category updatedCategory = new Category(2L, "Updated Category 1", "Updated Category 1 details", false);
        when(categoryRepository.findById(existingCategory.getId())).thenReturn(Optional.of(existingCategory));
        when(categoryRepository.save(existingCategory)).thenReturn(updatedCategory);
        Category savedCategory = underTest.update(existingCategory.getId(), updatedCategory);
        verify(categoryRepository).findById(existingCategory.getId());
        verify(categoryRepository).save(existingCategory);
        assertEquals(updatedCategory, savedCategory);
    }
    @Test
    public void testActivation() {
        Category existingCategory = new Category(1L, "Category 1", "Category 1 details", true);
        when(categoryRepository.findById(existingCategory.getId())).thenReturn(Optional.of(existingCategory));
        when(categoryRepository.save(existingCategory)).thenReturn(existingCategory);

        Category activatedCategory = underTest.activation(existingCategory.getId(),existingCategory.getActivated());

        verify(categoryRepository).findById(existingCategory.getId());
        verify(categoryRepository).save(existingCategory);
        assertEquals(true, activatedCategory.getActivated());
    }

}