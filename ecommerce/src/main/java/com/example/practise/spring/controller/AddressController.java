package com.example.practise.spring.controller;

import com.example.practise.spring.dto.AddressDto;
import com.example.practise.spring.entity.Address;
import com.example.practise.spring.service.interfaces.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<AddressDto> getAddresses(){
        return addressService.getAddresses();
    }
    @PostMapping
    public Address addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }

    @GetMapping("/customer/{id}")
    public List<AddressDto> getAddressesByCustomerId(@PathVariable Long id) {
        return addressService.findByCustomerId(id);
    }
}
