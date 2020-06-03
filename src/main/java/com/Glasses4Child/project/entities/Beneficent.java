package com.Glasses4Child.project.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
public class Beneficent extends User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false, unique = true, updatable = false)
    private String document;

    @Setter
    private String pseudonym;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private Date bornDate;

    @OneToOne
    Prescription prescription;

    public Beneficent(String name, Long telephone, String document, String pseudonym, Date bornDate, Address address, Login login, Prescription prescription) {
        super(name, telephone, address, login);
        this.document = document;
        this.pseudonym = pseudonym;
        this.bornDate = bornDate;
        this.prescription = prescription;
    }

    public Beneficent(String name, Long telephone, String document, String pseudonym, Date bornDate, Address address, Login login) {
        super(name, telephone, address, login);
        this.document = document;
        this.pseudonym = pseudonym;
        this.bornDate = bornDate;
    }
}