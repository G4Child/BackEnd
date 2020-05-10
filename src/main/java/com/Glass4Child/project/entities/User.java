package com.Glass4Child.project.entities;


import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;


@MappedSuperclass
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String document;
    private String name;
    private String email;
    private Long telephone;
    private String password;
    private String cep;

    public User() {
    }

    public User(String name, String email, Long telephone, String password, String document, String cep) {
        super();
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.document = document;
        this.cep = cep;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(document, user.document) &&
                Objects.equals(telephone, user.telephone) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, document, telephone, password);
    }
}