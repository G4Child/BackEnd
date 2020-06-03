package com.Glasses4Child.project.entities;

import lombok.*;

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
    @Setter
    @Column(nullable = false, unique = true, updatable = false)
    private String examAttach;

    @Setter
    private String comments;

    @OneToOne
    @JoinColumn
    private Degree nearDegree;

    @OneToOne
    @JoinColumn
    private Degree farDegree;

    @ManyToOne
    @JoinColumn
    private Dependent dependentToPrescription;

    public Prescription(String examAttach, String comments, Degree nearDegree, Degree farDegree) {
        this.examAttach = examAttach;
        this.nearDegree = nearDegree;
        this.farDegree = farDegree;
        this.comments = comments;
    }
}