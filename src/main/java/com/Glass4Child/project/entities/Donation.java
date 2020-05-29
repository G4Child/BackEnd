package com.Glass4Child.project.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class Donation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant date = Instant.now();
    private double amount;
    @Setter
    private double deductedAmount = 0.0;

    @JoinColumn
    @ManyToOne
    private Beneficent beneficent;

    public Donation(double amount, Beneficent beneficent) {
        this.amount = amount;
        this.beneficent = beneficent;
    }
}