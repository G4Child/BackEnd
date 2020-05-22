package com.Glass4Child.project.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Prescription implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String attach;
    @OneToOne
    @JoinColumn(name="id_near")
    private Degree near_Degree;

    @OneToOne
    @JoinColumn(name="id_far")
    private Degree far_Degree;
    public Prescription() {
    }

    public Prescription(String attach, Degree near_Degree, Degree far_Degree) {
        this.attach = attach;
        this.near_Degree = near_Degree;
        this.far_Degree = far_Degree;
    }

    public String getAttach() {
        return attach;
    }
}
