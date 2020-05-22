package com.Glass4Child.project.entities;

//import org.springframework.data.annotation.Id;
import javax.persistence.Id;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Dependent  implements Serializable {private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


@OneToOne
private Prescription Prescription;

@OneToOne
private Donate Donete;


    private String nome;


    @ManyToOne
   @JoinColumn(name = "benefied_id")
    protected Benefited Benefied;





    private String document;
    private String bornDate;
    private String kinship;

    public Dependent() {
    }

    public Dependent(String nome, String document, String bornDate, String kinship, Prescription Prescription) {
        this.nome = nome;
        this.document = document;
        this.bornDate = bornDate;
        this.kinship = kinship;
        this.Prescription=Prescription;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getDocument() {
        return document;
    }


    public void setDocument(String document) {
        this.document = document;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    public String getKinship() {
        return kinship;
    }

    public void setKinship(String kinship) {
        this.kinship = kinship;
    }
}
