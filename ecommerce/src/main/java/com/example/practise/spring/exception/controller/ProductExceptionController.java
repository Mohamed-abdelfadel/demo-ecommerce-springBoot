//package com.example.practise.spring.exception.controller;
//
//import com.example.practise.spring.exception.ProductNotFound;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestControllerAdvice
//public class ProductExceptionController {
//
//    @ExceptionHandler(ProductNotFound.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public Map<String, Object> productNotFound(Exception e){
//        Map<String, Object> errorMessage = new HashMap<>();
//        errorMessage.put("Code",1);
//        return errorMessage;
//    }
//}
