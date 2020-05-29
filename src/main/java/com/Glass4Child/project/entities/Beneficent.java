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
public class Beneficent extends User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NonNull
    private String document;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private Date bornDate;

    public Beneficent(String name, Long telephone, String document, Integer donationLimit, Integer totalDonatedBeneficent, String pseudonym, Date bornDate, Address address) {
        super(name, telephone, address);
        this.document = document;
        this.donationLimit = donationLimit;
        this.totalDonated = totalDonatedBeneficent;
        this.everDonated = true;
        this.pseudonym = pseudonym;
        this.bornDate = bornDate;
    }

    public Beneficent(String name, Long telephone, String document, Integer donationLimit, String pseudonym, Date bornDate, Address address) {
        super(name, telephone, address);
        this.document = document;
        this.donationLimit = donationLimit;
        this.totalDonated = 0;
        this.everDonated = false;
        this.pseudonym = pseudonym;
        this.bornDate = bornDate;
    }
}