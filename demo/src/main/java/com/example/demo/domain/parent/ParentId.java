package com.example.demo.domain.parent;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ParentId implements Serializable {
    private String id1;
    private String id2;

    public ParentId(String id1) {
    }
}
