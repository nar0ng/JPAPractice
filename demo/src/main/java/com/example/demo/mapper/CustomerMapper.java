package com.example.demo.mapper;

import com.example.demo.domain.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    void save(Customer customer);
    Customer findById(Long id);
}
