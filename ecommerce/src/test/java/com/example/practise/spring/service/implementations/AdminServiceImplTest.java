package com.example.practise.spring.service.implementations;

import com.example.practise.spring.entity.Admin;
import com.example.practise.spring.repository.AdminRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

class AdminServiceImplTest {
    @Autowired
    private AdminRepository adminRepository;
    private AdminServiceImpl underTest;

    @BeforeEach
    void setUp() {
        adminRepository = Mockito.mock(AdminRepository.class);
        underTest = new AdminServiceImpl(adminRepository);
    }

    @Test
    public void testGetAdmin() {
        List<Admin> admins = new ArrayList<>();
        admins.add(new Admin(1L, "Mohamed yasser", "mohamed@gmail.com", "01121118319"));
        admins.add(new Admin(2L, "Mohamed yasser", "mohamed2@gmail.com", "01121118319"));
        when(adminRepository.findAll()).thenReturn(admins);
        List<Admin> foundAdmins = underTest.getAdmin();
        verify(adminRepository).findAll();
        assertEquals(admins, foundAdmins);
    }

    @Test
    public void testAddAdmin() {
        Admin admin = new Admin(1L, "Mohamed yasser", "mohamed@gmail.com", "01121118319");
        when(adminRepository.save(admin)).thenReturn(admin);
        Admin savedAdmin = underTest.addAdmin(admin);
        verify(adminRepository, times(1)).save(admin);
        assertEquals(admin, savedAdmin);
    }
}