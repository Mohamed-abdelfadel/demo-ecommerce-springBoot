package com.example.practise.spring.controller;

import com.example.practise.spring.dto.ProductDto;
import com.example.practise.spring.entity.Product;
import com.example.practise.spring.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private  ProductService productService;


    @GetMapping
    public List<ProductDto> get(){
        return productService.get();
    }
    @PostMapping("/{id}")
    public Product add(@PathVariable Long id ,@RequestBody Product product){
        return productService.add(id,product);
    }
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return productService.update(id, product);
    }


    @PutMapping("/{id}/deactivate")
    public Product deactivate(@PathVariable Long id){
        return productService.deactivate(id);
    }
    @PutMapping("/{id}/activate")
    public Product activate(@PathVariable Long id){
        return productService.activate(id);
    }


    @GetMapping("/price/{minValue}/{maxValue}")
    public List<ProductDto> priceRange(@PathVariable Double minValue ,@PathVariable Double maxValue ){
        return productService.priceBetween(minValue, maxValue);
    }
    @GetMapping("/category/{id}/price/{minValue}/{maxValue}")
    public List<ProductDto> getProductsByCategoriesAndPrices(@PathVariable Long id ,@PathVariable Double minValue ,@PathVariable Double maxValue ){
        return productService.getProductsByCategoriesAndPrices(minValue,maxValue,id);
    }
    @GetMapping("/category/{id}")
    public List<ProductDto> categoryProducts(@PathVariable Long id){
        return productService.getAllProductsByCategoryId(id);
    }
}
