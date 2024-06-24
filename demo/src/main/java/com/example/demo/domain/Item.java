package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Objects;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
@Table(name = "item")
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
public class Item extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private int price;
    private int stockQuantity;

    @ManyToOne // 오더아이템이 하나일 때 아이템이 여러 개
    @JoinColumn(name = "order_item_id", referencedColumnName = "id")
    private OrderItem orderItem;

    public void setOrderItem(OrderItem orderItem){
        if (Objects.nonNull(this.orderItem)){
            this.orderItem.getItems().remove(this);
        }

        this.orderItem = orderItem;
        orderItem.getItems().add(this);
    }

}
