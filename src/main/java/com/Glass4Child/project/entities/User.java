package com.Glass4Child.project.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass @NoArgsConstructor @EqualsAndHashCode
public abstract class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Getter
    private String document;
    @Getter
    private String name;
    @Getter @Setter
    private Long telephone;
    @Getter @Setter
    private boolean isActive;

    @OneToOne
    protected Address address;

    public User(String name, Long telephone, String document, Address address) {
        super();
        this.name = name;
        this.telephone = telephone;
        this.document = document;
        this.address = address;
        isActive = true;
    }
}