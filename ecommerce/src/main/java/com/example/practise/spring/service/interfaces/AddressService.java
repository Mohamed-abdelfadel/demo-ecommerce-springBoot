package com.example.practise.spring.service.interfaces;

import com.example.practise.spring.dto.AddressDto;
import com.example.practise.spring.entity.Address;
import java.util.List;

public interface AddressService {


    List<AddressDto> getAddresses();

    Address addAddress(Address address);

    List<AddressDto>findByCustomerId(Long id);
}
