package com.Glass4Child.project.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant date;
    private String paymentMethod;
    @ManyToMany
    @JoinTable(name = "paymentRecord")
    private List<Record> record;

    public Payment(Instant date, String paymentMethod) {
        this.date = date;
        this.paymentMethod = paymentMethod;
    }
}