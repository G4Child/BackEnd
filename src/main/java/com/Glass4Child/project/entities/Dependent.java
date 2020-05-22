package com.Glass4Child.project.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @NoArgsConstructor
public class Dependent implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Prescription prescription;

    @OneToOne
    private Donate donate;

    @ManyToOne
    @JoinColumn(name = "benefited_id")
    protected Benefited benefited;

    private String nome;
    private String document;
    private String bornDate;
    private String kinship;

    public Dependent(String nome, String document, String bornDate, String kinship, Prescription prescription) {
        this.nome = nome;
        this.document = document;
        this.bornDate = bornDate;
        this.kinship = kinship;
        this.prescription = prescription;
    }
}