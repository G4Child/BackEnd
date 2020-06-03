package com.Glasses4Child.project.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Getter
@NoArgsConstructor
@Entity
public class Record implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name="id", insertable = false, updatable = false, nullable = false)
//    private UUID id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant date = Instant.now();
    @Column(nullable = false, updatable = false)
    private String status;

    @ManyToOne(optional = false)
    @JoinColumn
    private Donation donation;

    @ManyToOne(optional = false)
    @JoinColumn
    private Glasses glasses;

    public Record(String status, Donation donation, Glasses glasses) {
        this.status = status;
        this.donation = donation;
        this.glasses = glasses;
    }
}