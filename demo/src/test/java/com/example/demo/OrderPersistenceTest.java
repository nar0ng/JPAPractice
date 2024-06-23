package com.example.demo;

import com.example.demo.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class OrderPersistenceTest {

    @Autowired
    EntityManagerFactory emf;

    @Test
    void member_insert(){
        Member member = Member.builder()
                .name("narong")
                .address("서울시 동작구(만) 움직이면 쏜다")
                .age(25)
                .nickName("kim")
                .description("백엔드 해요")
                .build();

        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction =  entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(member);

        transaction.commit();
    }
}
