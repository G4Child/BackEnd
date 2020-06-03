package com.Glasses4Child.project.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode
@Getter
@NoArgsConstructor
@Entity
public class Login implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private Long id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name="id", insertable = false, updatable = false, nullable = false)
//    private UUID id;

    @Email
    @Setter
    @Column(nullable = false, unique = true, updatable = false)
    private String email;
    @Setter
    @Column(nullable = false)
    private String password;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }
}