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

    @ManyToMany(mappedBy = "glasses")
    private List<Donate> donate;

    @OneToMany
    @JoinColumn(name = "glasses_id")
    private List<Record> record;

    public Glasses(float price, List<Record> record) {
        this.price = price;
        this.record = record;
    }
}