package com.Glass4Child.project.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Dependent implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name="id", insertable = false, updatable = false, nullable = false)
//    private UUID id;

    @ManyToOne
    @JoinColumn
    protected Benefited benefited;

    private String nome;
    private String document;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private Date bornDate;
    private String kinship;
    @Setter
    private boolean isActive = true;

    public Dependent(String nome, String document, Date bornDate, String kinship, Benefited benefited) {
        this.nome = nome;
        this.document = document;
        this.bornDate = bornDate;
        this.kinship = kinship;
        this.benefited = benefited;
    }
}