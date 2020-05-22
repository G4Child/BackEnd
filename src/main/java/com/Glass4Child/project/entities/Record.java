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

    @JoinColumn(name = "donate_id")
    @ManyToOne
    private Donate donate;
    @JoinColumn(name = "glasses_id")
    @ManyToOne
    private Glasses glasses;
    @ManyToMany
    @JoinColumn(name = "paymentRecord")
    private List<Payment> payment;

    public Record(Date date, String status) {
        this.date = date;
        this.status = status;
    }
}