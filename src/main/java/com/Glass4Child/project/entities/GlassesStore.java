package com.Glass4Child.project.entities;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GlassesStore extends User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String document;

    public GlassesStore(String name, Long telephone, String document, Address address, Long id) {
        super(name, telephone, address);
        this.document = document;
        this.id = id;
    }
}