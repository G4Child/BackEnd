package com.Glass4Child.project.entities;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Beneficent extends User implements Serializable {
    private static final long serialVersionUID = 1L;
    private int donationLimit = 0;
    private int totalDonatedBeneficent = 0;
    private boolean everDonated = false;
    private String pseudonym;

    public Beneficent() {
    }

    public Beneficent(String name, String email, Long telephone, String password, String document, int donationLimit, int totalDonatedBeneficent, String pseudonym, String cep) {
        super(name, email, telephone, password, document, cep);
        this.donationLimit = donationLimit;
        this.totalDonatedBeneficent = totalDonatedBeneficent;
        this.everDonated = true;
        this.pseudonym = pseudonym;
    }

    public Beneficent(String name, String email, Long telephone, String password, String document, int donationLimit, String pseudonym, String cep) {
        super(name, email, telephone, password, document, cep);
        this.donationLimit = donationLimit;
        this.totalDonatedBeneficent = 0;
        this.everDonated = false;
        this.pseudonym = pseudonym;
    }

    @OneToOne(mappedBy = ("beneficent"))
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getDonationLimit() {
        return donationLimit;
    }

    public void setDonationLimit(int DonationLimit) {
        this.donationLimit = DonationLimit;
    }

    public int getTotalDonatedBeneficent() {
        return totalDonatedBeneficent;
    }

    public void setTotalDonatedBeneficent(int totalDonatedBeneficent) {
        this.totalDonatedBeneficent = totalDonatedBeneficent;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public boolean isEverDonated() {
        return everDonated;
    }

    public void setEverDonated(boolean EverDonated) {
        this.everDonated = EverDonated;
    }

    public void setNewDonationLimit(int value) {
        if (this.donationLimit > value) {
            this.donationLimit = value;
        }
        this.totalDonatedBeneficent = value + this.totalDonatedBeneficent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Beneficent that = (Beneficent) o;
        return donationLimit == that.donationLimit &&
                totalDonatedBeneficent == that.totalDonatedBeneficent &&
                everDonated == that.everDonated;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), donationLimit, totalDonatedBeneficent, everDonated);
    }
}
