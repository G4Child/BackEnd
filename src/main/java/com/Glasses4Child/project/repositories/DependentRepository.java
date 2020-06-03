package com.Glasses4Child.project.repositories;

import com.Glasses4Child.project.entities.Dependent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DependentRepository extends JpaRepository<Dependent, Long> {
    Dependent findByDocument(String Document);
}