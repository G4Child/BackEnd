package com.Glass4Child.project.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@NoArgsConstructor
@EqualsAndHashCode
@Getter
public abstract class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @NonNull
    @Column(nullable = false)
    private String name;
    @Setter
    @NonNull
    @Column(nullable = false)
    private Long telephone;
    @Setter
    @Column(nullable = false)
    private boolean isActive = true;

    @NonNull
    @OneToOne(optional = false)
    protected Address address;

    @NonNull
    @OneToOne(optional = false)
    protected Login login;

    public User(String name, Long telephone, Address address, Login login) {
        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.login = login;
    }
}