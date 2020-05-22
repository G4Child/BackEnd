package com.Glass4Child.project.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String paymentMethod;
    @ManyToMany(mappedBy = "Payment")
    private List<Donate> Donate;

    public Payment(Date date, String paymentMethod) {
        this.date = date;
        this.paymentMethod = paymentMethod;
    }

    public Payment() {
    }

    public Date getDate() {
        return date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
