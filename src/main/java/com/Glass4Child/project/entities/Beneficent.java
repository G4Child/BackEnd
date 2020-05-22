package com.Glass4Child.project.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Beneficent extends User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Integer donationLimit = 0;
    @Getter
    private Integer totalDonated = 0;
    @Getter
    @Setter
    private Boolean everDonated = false;
    @Getter
    @Setter
    private String pseudonym;
    @Getter
    private Date bornDate;

    @JoinColumn(name = "beneficent_id")
    @OneToMany
    private List<Donate> donate;

    public Beneficent(String name, Long telephone, String document, Integer donationLimit, Integer totalDonatedBeneficent, String pseudonym, Date bornDate, Address address) {
        super(name, telephone, document, address);
        this.donationLimit = donationLimit;
        this.totalDonated = totalDonatedBeneficent;
        this.everDonated = true;
        this.pseudonym = pseudonym;
        this.bornDate = bornDate;
        this.address = address;
    }

    public Beneficent(String name, Long telephone, String document, Integer donationLimit, String pseudonym, Date bornDate, Address address) {
        super(name, telephone, document, address);
        this.donationLimit = donationLimit;
        this.totalDonated = 0;
        this.everDonated = false;
        this.pseudonym = pseudonym;
        this.bornDate = bornDate;
        this.address = address;
    }
}