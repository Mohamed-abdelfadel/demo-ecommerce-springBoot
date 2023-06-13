package com.example.practise.spring.seeder;

import com.example.practise.spring.entity.*;
import com.example.practise.spring.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
@Component
public class DataSeeder {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final  CustomerRepository customerRepository;
    private final  AddressRepository addressRepository;
    private final OrderStatusRepository orderStatusRepository;
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    private final Faker faker;
    private static final Random random = new Random();

    @Autowired
    public DataSeeder(CategoryRepository categoryRepository, ProductRepository productRepository , OrderStatusRepository orderStatusRepository , CustomerRepository customerRepository, OrderRepository orderRepository , AddressRepository addressRepository, ItemRepository itemRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.orderStatusRepository = orderStatusRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.addressRepository = addressRepository;
        this.itemRepository = itemRepository;
        this.faker = new Faker();
    }

    @PostConstruct
    public void seedData() {
        seedCategories();
        seedProducts();
        seedOrderStatus();
        seedCustomers();
        seedAddresses();
        seedOrders();
        seedItems();
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
            product.setStock(faker.random().nextInt(1, 50));
            product.setCategory(categories.get(faker.random().nextInt(categories.size())));
            product.setActivated(faker.random().nextBoolean());
            products.add(product);
        }
        productRepository.saveAll(products);
    }

    private void seedCustomers() {
        List<Customer> customers = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            Customer customer = new Customer();
            customer.setName(faker.name().fullName());
            customer.setEmail(faker.internet().emailAddress());
            customer.setPhone(faker.phoneNumber().cellPhone());
            customers.add(customer);
        }
        customerRepository.saveAll(customers);
    }

    private void seedAddresses() {
        List<Address> addresses = new ArrayList<>();
        List<Customer> customers = customerRepository.findAll();
        for (int i = 1; i <= 100; i++) {
            Address address = new Address();
            address.setName(faker.address().fullAddress());
            address.setCustomer(customers.get(faker.random().nextInt(customers.size())));
            addresses.add(address);
        }
        addressRepository.saveAll(addresses);
    }

    private void seedOrders() {
        List<Order> orders = new ArrayList<>();
        List<Customer> customers = customerRepository.findAll();
        List<OrderStatus> statuses = orderStatusRepository.findAll();
        for (int i = 1; i <= 100; i++) {
            Order order = new Order();
            order.setDate(faker.date().future(365, TimeUnit.DAYS));
            order.setReceived(faker.random().nextBoolean());
            order.setStatus(statuses.get(faker.random().nextInt(statuses.size())));
            order.setCustomer(customers.get(faker.random().nextInt(customers.size())));
            orders.add(order);
        }
        orderRepository.saveAll(orders);
    }

    public void seedItems() {
        List<Order> orders = orderRepository.findAll();
        List<Product> products = productRepository.findAll();

        for (int i = 1; i <= 300; i++) {
            Item item = new Item();
            item.setAmount(random.nextInt(10));
            item.setOrder(orders.get(faker.random().nextInt(orders.size())));
            item.setProduct(products.get(faker.random().nextInt(products.size())));
            itemRepository.save(item);
        }
    }
}