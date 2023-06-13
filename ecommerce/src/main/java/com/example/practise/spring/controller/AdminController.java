package com.example.practise.spring.controller;

import com.example.practise.spring.entity.Admin;
import com.example.practise.spring.service.implementations.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;
    @GetMapping
    public List<Admin> getAdmin(){
        return adminService.getAdmin();
    }

    @PostMapping
    public Admin addAdmin(@RequestBody Admin admin){
        return adminService.addAdmin(admin);
    }
}
