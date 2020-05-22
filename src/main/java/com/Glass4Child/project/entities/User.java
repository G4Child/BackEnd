package com.Glass4Child.project.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
public abstract class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String document;
    private String name;
    private Long telephone;
    private boolean isActive;

    @OneToOne
    protected Address address;

    public User() {
    }

    public User(String name, Long telephone, String document, Address address) {
        super();
        this.name = name;
        this.telephone = telephone;
        this.document = document;
        this.address = address;
        isActive = true;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isActive() == user.isActive() &&
                getDocument().equals(user.getDocument()) &&
                getName().equals(user.getName()) &&
                getTelephone().equals(user.getTelephone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDocument(), getName(), getTelephone(), isActive());
    }
}