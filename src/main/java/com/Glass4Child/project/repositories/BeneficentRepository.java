package com.Glass4Child.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Glass4Child.project.entities.Beneficent;

import java.util.Optional;

public interface BeneficentRepository extends JpaRepository<Beneficent, Long> {

    Optional<Beneficent> findByDocument(String document);
}
