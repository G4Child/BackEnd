package com.Glass4Child.project.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity
@NoArgsConstructor @Data
public class Donate implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant date;
    private String price;

    @OneToMany(mappedBy = "donate")
    private List<Record> record;






    @JoinColumn(name="beneficent_id")
    @ManyToOne
    private Beneficent beneficent;
    @OneToOne
    private Dependent dependent;

    public Donate(Instant date, String price, Beneficent beneficent, Dependent dependent) {
        this.date = date;
        this.price = price;

        this.beneficent = beneficent;
        this.dependent = dependent;
    }
}