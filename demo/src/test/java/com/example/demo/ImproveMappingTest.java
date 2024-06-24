package com.example.demo;

import com.example.demo.domain.Food;
import com.example.demo.domain.Order;
import com.example.demo.domain.OrderStatus;
import com.example.demo.domain.parent.Parent;
import com.example.demo.domain.parent.ParentId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

import static ch.qos.logback.classic.spi.ThrowableProxyVO.build;

@Slf4j
@SpringBootTest
public class ImproveMappingTest {
    @Autowired
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

    @Test
    void mapped_super_class_test(){
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction =  entityManager.getTransaction();

        transaction.begin();

        Order order = Order.builder()
                .uuid(UUID.randomUUID().toString())
                .orderStatus(OrderStatus.OPENED)
                .memo("---")
                .orderDateTime(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .createdBy("백종원")
                .build();

        entityManager.persist(order);

        transaction.commit();
    }

    @Test
    void id_test(){
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction =  entityManager.getTransaction();

        transaction.begin();

        Parent parent = new Parent();
        parent.setId1(new ParentId("id1"));

        entityManager.persist(parent);
        transaction.commit();

        entityManager.clear();
        Parent parent1 = entityManager.find(Parent.class, new ParentId("id1", "id2"));

    }
}
