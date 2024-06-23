package com.example.demo;

import com.example.demo.domain.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
public class PersistenceContextTest {

    @Autowired
    CustomerRepository repository;

    @Autowired
    EntityManagerFactory emf;




    @Test
    void 저장(){
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Customer customer = new Customer(); // 비영속상태
        customer.setId(2L);
        customer.setFirstName("narong");
        customer.setLastName("kim");

        entityManager.persist(customer); // 비영속 -> 영속 (영속화)
        transaction.commit(); // entityManager.flush();
    }

    @Test
    void test_save(){
            Customer customer = new Customer();
            customer.setId(1L);
            customer.setFirstName("John");
            customer.setLastName("Doe");
            repository.save(customer);

            assertNotNull(repository.findById(customer.getId()).orElse(null));

    }
}
