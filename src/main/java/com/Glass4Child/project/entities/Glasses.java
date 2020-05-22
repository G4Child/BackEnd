package com.Glass4Child.project.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Glasses implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float price;


    @ManyToMany(mappedBy = "Glasses")
    private List<Donate> Donate;



    public Glasses() {
    }

    public Glasses(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }
}
