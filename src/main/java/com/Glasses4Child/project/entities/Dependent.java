package com.Glasses4Child.project.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Dependent implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false, unique = true, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name="id", insertable = false, updatable = false, nullable = false)
//    private UUID id;

    @ManyToOne
    @JoinColumn
    protected Benefited benefited;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true, updatable = false)
    private String document;
    @Setter
    @Column(nullable = false, unique = true)
    private String pseudonym;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private Date bornDate;
    @Column(nullable = false, updatable = false)
    private String kinship;
    @Setter
    @Column(nullable = false)
    private boolean isActive = true;

    @Setter
    @OneToMany(mappedBy = "dependentToPrescription")
    List<Prescription> prescriptions = new ArrayList<>();

    public Dependent(String nome, String pseudonym, String document, Date bornDate, String kinship, Benefited benefited, Prescription prescription) {
        this.nome = nome;
        this.pseudonym = pseudonym;
        this.document = document;
        this.bornDate = bornDate;
        this.kinship = kinship;
        this.benefited = benefited;
        this.prescriptions.add(prescription);
    }
}