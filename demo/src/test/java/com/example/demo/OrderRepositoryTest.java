package com.example.demo;

import com.example.demo.domain.Member;
import com.example.demo.domain.MemberRepository;
import com.example.demo.domain.Order;
import com.example.demo.domain.OrderRepository;
import com.example.demo.domain.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
public class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void test(){

        String uuid = UUID.randomUUID().toString();

        Order order1 = Order.builder()
                .uuid(uuid)
                .orderStatus(OrderStatus.OPENED)
                .orderDateTime(LocalDateTime.now())
                .createdBy("narong")
                .memo("hello")
                .createdAt(LocalDateTime.now())
                .build();

        orderRepository.save(order1);

        orderRepository.findAllByOrderStatus(OrderStatus.OPENED);
        orderRepository.findAllByOrderStatusOrderByOrderDateTime(OrderStatus.OPENED);
    }
}
