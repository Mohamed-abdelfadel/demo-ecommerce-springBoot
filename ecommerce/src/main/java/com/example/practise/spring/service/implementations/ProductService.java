package com.example.practise.spring.service;

import com.example.practise.spring.dto.ProductDto;
import com.example.practise.spring.entity.Category;
import com.example.practise.spring.entity.Product;
import com.example.practise.spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public List<Product> get() {
            return productRepository.findAll();
        }
    public Product add(Product product) {
        return productRepository.save(product);
    }
    public Product update(Long productId, Product product) {
        Product existingProduct = productRepository.findById(productId).orElseThrow();
        if (product.getName() != null) {
            existingProduct.setName(product.getName());
        }
        if (product.getDetails() != null) {
            existingProduct.setDetails(product.getDetails());
        }
        if (product.getCategory() != null) {
            existingProduct.setCategory(product.getCategory());
        }
        if (product.getCost() != null) {
            existingProduct.setCost(product.getCost());
        }
        if (product.getPrice() != null) {
            existingProduct.setPrice(product.getPrice());
        }
        if (product.getAmount() != null) {
            existingProduct.setAmount(product.getAmount());
        }
        if (product.getActivated() != null) {
            existingProduct.setActivated(product.getActivated());
        }
        return productRepository.save(existingProduct);
    }

    public Product activate(Long id) {
        Product existingProduct = productRepository.findById(id).orElseThrow();
        existingProduct.setActivated(true);
        return productRepository.save(existingProduct);
    }
    public Product deactivate(Long id) {
        Product existingProduct = productRepository.findById(id).orElseThrow();
        existingProduct.setActivated(false);
        return productRepository.save(existingProduct);
    }

    public List<Product> priceBetween(Double minValue , Double maxValue){
        return productRepository.findAllByPriceBetween(minValue, maxValue);
    }
    public List<ProductDto> getProductsByCategoriesAndPrices(Double minValue, Double maxValue, Long categoryId) {
        return productRepository.getProductsByCategoriesAndPrices(minValue, maxValue, categoryId);
    }
    public List<ProductDto> getAllProductsByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }
//    public void deleteProduct(Long id) {
//        productRepository.deleteById(id);
//    }

//    public Product getProduct(Long id) {
//        return productRepository.findById(id).orElseThrow();
//    }

//    public List<Product> getActivatedProducts() {
//        return productRepository.findByActivatedTrue();
//    }

//    public List<Product> getDeactivatedProducts() {
//        return productRepository.findByActivatedFalse();
//    }

//    TODO->NOT WORKING
//    public List<Product> getProductsByCategoryId(Long id) {
//        return productRepository.findByCategoryId(id);
//    }


//    public Category getCategoryById(Long id){
//        return productRepository.findCategoryByProductId(id);
//    }

}
