package com.example.demo.domain.parent;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Parent {
    @EmbeddedId
    private ParentId id1;
}
