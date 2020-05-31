package com.Glass4Child.project.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Glasses implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name="id", insertable = false, updatable = false, nullable = false)
//    private UUID id;

    private float price;

    @ManyToOne
    @JoinColumn
    private Dependent dependent;

    @OneToOne
    private GlassesStore glassesStore;

    public Glasses(float price, Dependent dependent, GlassesStore glassesStore) {
        this.price = price;
        this.dependent = dependent;
        this.glassesStore = glassesStore;
    }
}