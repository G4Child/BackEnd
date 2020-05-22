package com.Glass4Child.project.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Table(name = "tb_BENEFICENT")
public class Beneficent extends User implements Serializable {
    private static final long serialVersionUID = 1L;
//    @AllArgsConstructor
//    @Getter
//    @Setter

    private Integer donationLimit = 0;
    private Integer totalDonated = 0;
    private Boolean everDonated = false;
    private String pseudonym;
    private Date bornDate;
    @JoinColumn(name="beneficent_id")
    @OneToMany
    private List<Donate> Donete;

    public Beneficent() {
    }

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

    public Integer getDonationLimit() {
        return donationLimit;
    }

    public void setDonationLimit(int DonationLimit) {
        this.donationLimit = DonationLimit;
    }

    public Integer getTotalDonated() {
        return totalDonated;
    }

    public void setTotalDonated(int totalDonated) {
        this.totalDonated = totalDonated;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public Boolean isEverDonated() {
        return everDonated;
    }

    public void setEverDonated(Boolean EverDonated) {
        this.everDonated = EverDonated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Beneficent that = (Beneficent) o;
        return donationLimit == that.donationLimit &&
                totalDonated == that.totalDonated &&
                everDonated == that.everDonated;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), donationLimit, totalDonated, everDonated);
    }
}
