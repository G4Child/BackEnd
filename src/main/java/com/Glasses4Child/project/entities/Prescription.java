package com.Glasses4Child.project.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Prescription implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false, updatable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name="id", insertable = false, updatable = false, nullable = false)
//    private UUID id;

    @NonNull
    @Column(nullable = false, unique = true, updatable = false)
    private String examAttach;

    private String comments;

    @OneToOne
    @JoinColumn
    private Degree nearDegree;

    @OneToOne
    @JoinColumn
    private Degree farDegree;

    @ManyToOne(optional = false)
    @JoinColumn
    private Dependent dependent;

    public Prescription(String examAttach, String comments, Degree nearDegree, Degree farDegree, Dependent dependent) {
        this.examAttach = examAttach;
        this.nearDegree = nearDegree;
        this.farDegree = farDegree;
        this.dependent = dependent;
        this.comments = comments;
    }
}