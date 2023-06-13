package com.example.practise.spring.service.implementations;

import com.example.practise.spring.entity.Admin;
import com.example.practise.spring.repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminServiceImpl {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAdmin(){
        return adminRepository.findAll();
    }
    public Admin addAdmin(Admin admin){
        return adminRepository.save(admin);
    }
}
