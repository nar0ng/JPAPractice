package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity {
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;
}
