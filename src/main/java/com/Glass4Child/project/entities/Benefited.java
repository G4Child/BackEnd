package com.Glass4Child.project.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
//@Table(name = "tb_BENEFITED")
public class Benefited extends User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NonNull
    private String document;

    @Getter
    @Setter
    private Integer amountDependents;
    @Getter
    @Setter
    private Integer limitDependents;
    @Getter
    private String nis;
    @Getter
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private Date bornDate;

    public Benefited(String name, Long telephone, String document, Integer amountDependents, Integer limitDependents, String nis, Date bornDate, Address address) {
        super(name, telephone, address);
        this.document = document;
        this.bornDate = bornDate;
        this.amountDependents = amountDependents;
        this.limitDependents = limitDependents;
        this.nis = nis;
    }
}