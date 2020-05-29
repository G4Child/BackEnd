package com.Glass4Child.project.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@Entity
public class Login implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
