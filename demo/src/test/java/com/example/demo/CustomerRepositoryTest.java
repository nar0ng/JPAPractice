package com.example.demo;

import com.example.demo.domain.Customer;
import com.example.demo.domain.CustomerEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootTest
public class CustomerRepositoryTest {
    static final String CREATE_TABLE_SQL = "CREATE TABLE customers (id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))";

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    void test(){
        jdbcTemplate.update(CREATE_TABLE_SQL);
        // Given
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("narong");
        customer.setLastName("zi");

        // when
        repository.save(customer);

        // Then
        Customer entity = repository.findById(1L).get();
        log.info("{} {}", entity.getFirstName(), entity.getLastName());
    }

}
