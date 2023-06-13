package com.example.practise.spring.service.implementations;

import com.example.practise.spring.dto.AddressDto;
import com.example.practise.spring.entity.Address;
import com.example.practise.spring.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements com.example.practise.spring.service.interfaces.AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<AddressDto> getAddresses(){
        return addressRepository.findAllAddresses();
    }

    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    public List<AddressDto>findByCustomerId(Long id){
        return addressRepository.findByCustomerId(id);
    }
}
