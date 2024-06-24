package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @Column(name = "id")
    private String uuid;
    @Column(name = "memo")
    private String memo;
    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;
    @Column(name = "order_datetiem", columnDefinition = "TIMESTAMP")
    private LocalDateTime orderDateTime;

    // member_fk
    @Column(name = "member_id", insertable = false, updatable = false)
    private Long memberId;

    @ManyToOne // 회원 하나 당 주문이 여러 개 -> 주문이 다
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private Member memberG;

    public void setMember(Member member){
        if (Objects.nonNull(this.memberG)){
            member.getOrders().remove(this);
        }
        this.memberG = member;
        member.getOrders().add(this);
    }
}
