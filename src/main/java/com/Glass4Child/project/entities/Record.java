package com.Glass4Child.project.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant date = Instant.now();
    private String status;

    @ManyToOne
    @JoinColumn
    private Donation donation;

    @ManyToOne
    @JoinColumn
    private Glasses glasses;

    public Record(String status, Donation donation, Glasses glasses) {
        this.status = status;
        this.donation = donation;
        this.glasses = glasses;
    }
}