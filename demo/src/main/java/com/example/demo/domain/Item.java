package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private int price;
    private int stockQuantity;

    @ManyToOne // 오더아이템이 하나일 때 아이템이 여러 개
    @JoinColumn(name = "order_item_id", referencedColumnName = "id")
    private OrderItem orderItem;

}
