package com.Glasses4Child.project.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor
//@Table(name = "tb_ADDRESS")
//@RequiredArgsConstructor(onConstructor = true)
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ADDRESS", nullable = false, updatable = false, unique = true)
    private Long id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name="id", insertable = false, updatable = false, nullable = false)
//    private UUID id;

    @Setter
    @Column(nullable = false)
    private int number;
    @Setter
    @Column(nullable = false)
    private String streetAddress;
    @Setter
    private String complement;
    @Setter
    @Column(nullable = false)
    private String state;
    @Setter
    @Column(nullable = false)
    private String city;
    @Setter
    @Column(nullable = false)
    private String neighborhood;
    @Setter
    @Column(nullable = false)
    private String reference;

    public Address(int number, String complement, String state, String city, String neighborhood, String reference, String streetAddress) {
        this.number = number;
        this.complement = complement;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.reference = reference;
        this.streetAddress = streetAddress;
    }
}