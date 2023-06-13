package com.example.practise.spring.service.implementations;


import com.example.practise.spring.dto.AddressDto;
import com.example.practise.spring.entity.Address;
import com.example.practise.spring.entity.Customer;
import com.example.practise.spring.repository.AddressRepository;
import com.example.practise.spring.service.interfaces.AddressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class AddressServiceImplTest {
    @MockBean
    private AddressRepository addressRepository;
    private AddressService addressService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getAddresses() {
        addressService.getAddresses();
        verify(addressRepository).findAllAddresses();
    }

    @Test
    void addAddressTest() {
        var customer = new Customer(1L,"mohamed","mohamed@gmail.com","01121118319") ;
        var address = new Address(1L,"mac.st",customer) ;
        addressService.addAddress(address);
        ArgumentCaptor<Address> addressArgumentCaptor = ArgumentCaptor.forClass(Address.class);
        verify(addressRepository).save(addressArgumentCaptor.capture());
        Address captureAddress =addressArgumentCaptor.getValue();
        assertThat(captureAddress).isEqualTo(address);
    }

    @Test
    void addAddressTestTwo() {
        var customer = new Customer(1L,"mohamed","mohamed@gmail.com","01121118319") ;
        var address = new Address(1L,"mac.st",customer) ;
        when(addressRepository.save(address)).thenReturn(address);
        Address createdAddress = addressService.addAddress(address);
        verify(addressRepository, times(1)).save(address);
        assertEquals(address, createdAddress);
    }
    @Test
    void findByCustomerId() {
        Long id = 1L;
        List<AddressDto> expectedAddresses = new ArrayList<>();
        expectedAddresses.add(new AddressDto(1L, "123 Main St"));
        expectedAddresses.add(new AddressDto(2L, "456 Elm St"));
        when(addressRepository.findByCustomerId(id)).thenReturn(expectedAddresses);
        List<AddressDto> actualAddresses = addressService.findByCustomerId(id);
        verify(addressRepository).findByCustomerId(id);
        assertEquals(expectedAddresses, actualAddresses);
    }

    @TestConfiguration
    @Import(CommonServiceCOn.class)
    static class Config {

        @MockBean AddressRepository addressRepository;
        @Bean
        public AddressService addressService() {
            return new AddressServiceImpl(addressRepository);
        }
    }

}