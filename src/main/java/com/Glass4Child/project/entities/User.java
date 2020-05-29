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
    private String name;
    @Setter
    @NonNull
    private Long telephone;
    @Setter
    private boolean isActive = true;

    @NonNull
    @OneToOne
    protected Address address;

    public User(String name, Long telephone, Address address) {
        super();
        this.name = name;
        this.telephone = telephone;
        this.address = address;
    }
}