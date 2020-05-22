package com.Glass4Child.project.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data @NoArgsConstructor
public class Degree implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String SPHERE_R;
    private String SPHERE_L;
    private String CYLINDER_R;
    private String CYLINDER_L;
    private String AXIS_R;
    private String AXIS_L;
    private String PD_R;
    private String PD_L;

    public Degree(String SPHERE_R, String SPHERE_L, String CYLINDER_R, String CYLINDER_L, String AXIS_R, String AXIS_L, String PD_R, String PD_L) {
        this.SPHERE_R = SPHERE_R;
        this.SPHERE_L = SPHERE_L;
        this.CYLINDER_R = CYLINDER_R;
        this.CYLINDER_L = CYLINDER_L;
        this.AXIS_R = AXIS_R;
        this.AXIS_L = AXIS_L;
        this.PD_R = PD_R;
        this.PD_L = PD_L;
    }
}