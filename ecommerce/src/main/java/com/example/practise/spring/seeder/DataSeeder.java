package com.example.practise.spring.seeder;

import com.example.practise.spring.entity.Category;
import com.example.practise.spring.entity.OrderStatus;
import com.example.practise.spring.entity.Product;
import com.example.practise.spring.repository.CategoryRepository;
import com.example.practise.spring.repository.OrderStatusRepository;
import com.example.practise.spring.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeeder {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    private final OrderStatusRepository orderStatusRepository;
    private final Faker faker;

    @Autowired
    public DataSeeder(CategoryRepository categoryRepository, ProductRepository productRepository , OrderStatusRepository orderStatusRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.orderStatusRepository = orderStatusRepository;
        this.faker = new Faker();
    }

    @PostConstruct
    public void seedData() {
        seedCategories();
        seedProducts();
        seedOrderStatus();
    }

    private void seedOrderStatus() {
        List<OrderStatus> orderStatues = new ArrayList<>();
        String[] status = {"pending","received","refunded"};
        for (int i = 0; i < status.length; i++) {
            OrderStatus orderStatus = new OrderStatus();
            orderStatus.setName(status[i]);
            orderStatues.add(orderStatus);
        }
        orderStatusRepository.saveAll(orderStatues);
    }
    private void seedCategories() {
        List<Category> categories = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Category category = new Category();
            category.setName(faker.commerce().productName());
            category.setDetails(faker.lorem().sentence());
            category.setActivated(faker.random().nextBoolean());
            categories.add(category);
        }
        categoryRepository.saveAll(categories);
    }

    private void seedProducts() {
        List<Product> products = new ArrayList<>();
        List<Category> categories = categoryRepository.findAll();
        for (int i = 1; i <= 100; i++) {
            Product product = new Product();
            product.setName(faker.commerce().productName());
            product.setCost(faker.number().randomDouble(2, 10, 1000));
            product.setPrice(faker.number().randomDouble(2, 10, 2000));
            product.setBrand(faker.company().name());
            product.setDetails(faker.lorem().sentence());
            product.setAmount(faker.random().nextInt(1, 50));
            product.setCategory(categories.get(faker.random().nextInt(categories.size())));
            product.setActivated(faker.random().nextBoolean());
            products.add(product);
        }
        productRepository.saveAll(products);
    }
}