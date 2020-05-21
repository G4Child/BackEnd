package com.Glass4Child.project.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor @EqualsAndHashCode(callSuper = true)
//@Table(name = "tb_BENEFITED")
public class Benefited extends User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private Integer amountDependents;
    @Getter @Setter
    private Integer limitDependents;
    @Getter
    private String nis;
    @Getter
    private Date bornDate;

    public Benefited(String name, Long telephone, String document, Integer amountDependents, Integer limitDependents, String nis, Date bornDate, Address address) {
        super(name, telephone, document, address);
        this.bornDate = bornDate;
        this.amountDependents = amountDependents;
        this.limitDependents = limitDependents;
        this.nis = nis;
        this.address = address;
    }
}
