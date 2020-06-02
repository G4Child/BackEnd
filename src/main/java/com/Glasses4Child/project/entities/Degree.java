package com.Glasses4Child.project.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Degree implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false, updatable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name="id", insertable = false, updatable = false, nullable = false)
//    private UUID id;

    @Setter
    @Column(nullable = false)
    private String sphere_L;
    @Setter
    @Column(nullable = false)
    private String sphere_R;
    @Setter
    @Column(nullable = false)
    private String cylinder_L;
    @Setter
    @Column(nullable = false)
    private String cylinder_R;
    @Setter
    @Column(nullable = false)
    private String axis_L;
    @Setter
    @Column(nullable = false)
    private String axis_R;
    @Setter
    @Column(nullable = false)
    private String pd_L;
    @Setter
    @Column(nullable = false)
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