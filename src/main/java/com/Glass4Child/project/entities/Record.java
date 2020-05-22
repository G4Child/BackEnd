package com.Glass4Child.project.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Record implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String status;
    @ManyToMany
    @JoinTable(name = "paymentRecord")
    private List<Payment> payment;




    @ManyToOne
    @JoinColumn(name="donate_id")
    private Donate donate;
    @ManyToOne
    @JoinColumn(name = "glasses_id")
    private Glasses glasses;


    public Record(Date date, String status, List<Payment> payment, Donate donate, Glasses glasses) {
        this.date = date;
        this.status = status;
        this.payment = payment;
        this.donate = donate;
        this.glasses = glasses;
    }
}