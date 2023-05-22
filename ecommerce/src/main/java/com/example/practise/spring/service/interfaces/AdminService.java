package com.example.practise.spring.service.interfaces;

import com.example.practise.spring.entity.Admin;
import java.util.List;

public interface AdminService {

    List<Admin> getAdmin();
    Admin addAdmin(Admin admin);
}
