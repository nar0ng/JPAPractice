package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member")
public class Member extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @Column(name = "nick_name", nullable = false, length = 30, unique = true)
    private String nickName;
    @Column(name = "age", nullable = false)
    private int age;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "description")
    private String description;

    @Builder.Default
    @OneToMany(mappedBy = "memberG") // 관리하는 주체는 memberG다.
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order){
        order.setMember(this);
    }

}
