package com.Glass4Child.project.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Glasses implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float price;



    @OneToMany(mappedBy = "glasses")
    private List<Record> record;

    public Glasses(float price) {
        this.price = price;

    }
}