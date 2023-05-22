package com.example.practise.spring.service;

import com.example.practise.spring.dto.AddressDto;
import com.example.practise.spring.entity.Address;
import com.example.practise.spring.entity.Customer;
import com.example.practise.spring.entity.Order;
import com.example.practise.spring.entity.Product;
import com.example.practise.spring.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }

    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    public List<AddressDto>findByCustomerId(Long id){
        return addressRepository.findByCustomerId(id);
    }
}
