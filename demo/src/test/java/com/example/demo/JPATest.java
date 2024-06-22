package com.example.demo;

import com.example.demo.domain.CustomerEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.demo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class JPATest {

    @Autowired
    CustomerRepository repository;

    @BeforeEach
    void setUp() { }

    @AfterEach
    void tearDown(){
        repository.deleteAll();
    }

    @Test
    void INSERT_TEST() {
        // Given
        CustomerEntity customer = new CustomerEntity();
        customer.setId(1L);
        customer.setFirstName("naroong");
        customer.setLastName("zi");

        // When
        repository.save(customer);

        // Then
        CustomerEntity entity = repository.findById(1L).get();
        log.info("{} {}", entity.getFirstName(), entity.getLastName());
    }
}
