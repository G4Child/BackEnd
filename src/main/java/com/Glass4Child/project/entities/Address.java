package com.Glass4Child.project.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @NoArgsConstructor
//@Table(name = "tb_ADDRESS")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //  @Column(name = "ID_ADDRESS")
    private Long id;
    //	private String postalAddressCode; //TO DO: IMPLEMENT CLASS postalAddressCode
    private int number;
    private String streetAddress;
    private String complement;
    private String state;
    private String city;
    private String neighborhood;
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