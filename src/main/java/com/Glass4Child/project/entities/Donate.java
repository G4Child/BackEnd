package com.Glass4Child.project.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Donate implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String price;


    @ManyToMany
    @JoinTable(name = "PaymentRecord")
    private List<Payment> Payment;

    @ManyToMany
    @JoinTable(name = "Record")
    private List<Glasses> Glasses;




    @JoinColumn(name="beneficent_id")
    @ManyToOne
    private Beneficent Beneficent;
    @OneToOne
    private Dependent Dependent;
    public Donate(String date, String price, Beneficent Beneficent, Dependent Dependent, List<Glasses> Glasses, List<Payment> Payment) {
        this.date = date;
        this.price = price;
        this.Beneficent= Beneficent;
        this.Dependent= Dependent;
        this.Glasses = Glasses;

        this.Payment= Payment;
    }

    public Donate() {
    }

    public String getDate() {
        return date;
    }

    public String getPrice() {
        return price;
    }
}
