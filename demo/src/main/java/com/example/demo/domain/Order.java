package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@SuperBuilder
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private String uuid;

    @Lob
    private String memo;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(name = "order_datetime", columnDefinition = "TIMESTAMP")
    private LocalDateTime orderDateTime;

    // member_fk
    @ManyToOne(fetch = FetchType.LAZY) // 회원 하나 당 주문이 여러 개 -> 주문이 다
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private Member memberG;

    public void setMember(Member member){
        if (Objects.nonNull(this.memberG)){
            member.getOrders().remove(this);
        }
        this.memberG = member;
        member.getOrders().add(this);
    }

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

}
