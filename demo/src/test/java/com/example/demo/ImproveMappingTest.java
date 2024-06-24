package com.example.demo;

import com.example.demo.domain.Food;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static ch.qos.logback.classic.spi.ThrowableProxyVO.build;

@Slf4j
@SpringBootTest
public class ImproveMappingTest {
    private EntityManagerFactory emf;

    @Test
    void inheritance_test() {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction =  entityManager.getTransaction();

        transaction.begin();

        Food food = Food.builder()
                .chef("백종원")
                .price(1000)
                .stockQuantity(100)
                .build();

        entityManager.persist(food);

        transaction.commit();



    }
}
