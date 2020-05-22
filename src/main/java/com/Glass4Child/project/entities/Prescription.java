package com.Glass4Child.project.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class Prescription implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String attach;

    @OneToOne
    @JoinColumn(name = "id_near")
    private Degree nearDegree;

    @OneToOne
    @JoinColumn(name = "id_far")
    private Degree farDegree;

    public Prescription(String attach, Degree nearDegree, Degree farDegree) {
        this.attach = attach;
        this.nearDegree = nearDegree;
        this.farDegree = farDegree;
    }
}
