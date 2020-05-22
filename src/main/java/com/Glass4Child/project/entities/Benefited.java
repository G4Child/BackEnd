package com.Glass4Child.project.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Table(name = "tb_BENEFITED")
public class Benefited extends User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer amountDependents;
    private Integer limitDependents;
    private String nis;
    private Date bornDate;

    //@JoinColumn(name = "dependent_id")
    @JoinColumn(name = "benefied_id")
    @OneToMany
    protected List<Dependent> Dependent;

    public Benefited() {
    }

    public Benefited(String name, Long telephone, String document, Integer amountDependents, Integer limitDependents, String nis, Date bornDate, Address address,List<com.Glass4Child.project.entities.Dependent> Dependent) {
        super(name, telephone, document, address);
        this.bornDate = bornDate;
        this.amountDependents = amountDependents;
        this.limitDependents = limitDependents;
        this.nis = nis;
        this.address = address;
        this.Dependent= (List<com.Glass4Child.project.entities.Dependent>) Dependent;
    }

    public Integer getAmountDependents() {
        return amountDependents;
    }

    public void setAmountDependents(Integer amountDependents) {
        this.amountDependents = amountDependents;
    }

    public Integer getLimitDependents() {
        return limitDependents;
    }

    public void setLimitDependents(Integer limitDependents) {
        this.limitDependents = limitDependents;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String NIS) {
        this.nis = NIS;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Benefited benefited = (Benefited) o;
        return amountDependents.equals(benefited.amountDependents) &&
                limitDependents.equals(benefited.limitDependents) &&
                nis.equals(benefited.nis) &&
                bornDate.equals(benefited.bornDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), amountDependents, limitDependents, nis, bornDate);
    }
}
