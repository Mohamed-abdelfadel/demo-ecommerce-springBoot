package com.example.practise.spring.repository;

import com.example.practise.spring.dto.AddressDto;
import com.example.practise.spring.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    @Query("SELECT new com.example.practise.spring.dto.AddressDto(a.id, a.name) FROM Address a ")
    List<AddressDto> findAllAddresses();
    @Query("SELECT new com.example.practise.spring.dto.AddressDto(a.id, a.name) FROM Address a WHERE a.customer.id = :id")
    List<AddressDto> findByCustomerId(@Param("id") Long id);}
