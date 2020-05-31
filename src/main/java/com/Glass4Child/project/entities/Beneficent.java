package com.Glass4Child.project.entities;

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
    private String document;

    @Setter
    private Integer donationLimit = 0;
    private Integer totalDonated = 0;
    @Setter
    private Boolean everDonated = false;
    @Setter
    private String pseudonym;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private Date bornDate;

    public Beneficent(String name, Long telephone, String document, Integer donationLimit, Integer totalDonatedBeneficent, String pseudonym, Date bornDate, Address address, Login login) {
        super(name, telephone, address, login);
        this.document = document;
        this.donationLimit = donationLimit;
        this.totalDonated = totalDonatedBeneficent;
        this.everDonated = true;
        this.pseudonym = pseudonym;
        this.bornDate = bornDate;
    }

    public Beneficent(String name, Long telephone, String document, Integer donationLimit, String pseudonym, Date bornDate, Address address, Login login) {
        super(name, telephone, address, login);
        this.document = document;
        this.donationLimit = donationLimit;
        this.totalDonated = 0;
        this.everDonated = false;
        this.pseudonym = pseudonym;
        this.bornDate = bornDate;
    }
}