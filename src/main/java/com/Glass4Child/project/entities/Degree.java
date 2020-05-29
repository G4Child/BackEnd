package com.Glass4Child.project.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@NoArgsConstructor
public class Degree implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sphere_L;
    private String sphere_R;
    private String cylinder_L;
    private String cylinder_R;
    private String axis_L;
    private String axis_R;
    private String pd_L;
    private String pd_R;

    public Degree(String sphere_L, String sphere_R, String cylinder_L, String cylinder_R, String axis_L, String axis_R, String pd_L, String pd_R) {
        this.sphere_L = sphere_L;
        this.sphere_R = sphere_R;
        this.cylinder_L = cylinder_L;
        this.cylinder_R = cylinder_R;
        this.axis_L = axis_L;
        this.axis_R = axis_R;
        this.pd_L = pd_L;
        this.pd_R = pd_R;
    }
}