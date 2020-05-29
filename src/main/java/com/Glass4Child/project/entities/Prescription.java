package com.Glass4Child.project.entities;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String examAttach;

    private String comments;

    @OneToOne
    @JoinColumn
    private Degree nearDegree;

    @OneToOne
    @JoinColumn
    private Degree farDegree;

    @ManyToOne
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