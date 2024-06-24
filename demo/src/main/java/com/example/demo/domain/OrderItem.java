package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private int price;
    private int quantity;

    // fk
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "item_id")
    private Long itemId;

    @OneToMany(mappedBy = "item") // ordeerItem 하나 당 item 여러 개
    public List<Item> items;

}
