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
    @OneToMany
    @JoinColumn(name="donate_id")
    private List<Record> record;


    @ManyToMany
    @JoinTable(name = "PaymentRecord")
    private List<Payment> payments;

    @ManyToMany
    @JoinTable(name = "record")
    private List<Glasses> glasses;

    @JoinColumn(name="beneficent_id")
    @ManyToOne
    private Beneficent beneficent;
    @OneToOne
    private Dependent dependent;

    public Donate(Instant date, String price, List<Record> record, Beneficent beneficent, Dependent dependent) {
        this.date = date;
        this.price = price;
        this.record = record;
        this.beneficent = beneficent;
        this.dependent = dependent;
    }
}