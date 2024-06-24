package com.example.demo;

import com.example.demo.domain.Member;
import com.example.demo.domain.Order;
import com.example.demo.domain.OrderStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

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

    @Test
    @Transactional
    void 연관관계_테스트(){
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Member member = Member.builder()
                .name("narong")
                .nickName("narorong")
                .address("어디게")
                .age(25)
                .build();

        entityManager.persist(member);


        Order order = Order.builder()
                .uuid(UUID.randomUUID().toString())
                .orderStatus(OrderStatus.OPENED)
                .orderDateTime(LocalDateTime.now())
                .memo("부재 시 연락 남겨주세요")
                .memberG(member)
                .build();

        entityManager.persist(order);

        transaction.commit();

        log.info("{}", order.getMemberG()); // 객체 그래프

        entityManager.clear();
        Order entity = entityManager.find(Order.class, order.getUuid());

        log.info("{}", entity.getMemberG().getNickName());
        log.info("{}", entity.getMemberG().getOrders().size());

    }
}
