package com.Glasses4Child.project.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@Getter
@EqualsAndHashCode(callSuper = true)
public class GlassesStore extends User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false, updatable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name="id", insertable = false, updatable = false, nullable = false)
//    private UUID id;

    @NonNull
    @Column(nullable = false, updatable = false)
    private String document;

    public GlassesStore(String name, Long telephone, String document, Address address, Login login) {
        super(name, telephone, address, login);
        this.document = document;
    }
}