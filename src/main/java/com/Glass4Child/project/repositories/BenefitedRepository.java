package com.Glass4Child.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Glass4Child.project.entities.Benefited;
import java.util.Optional;

public interface BenefitedRepository extends JpaRepository<Benefited, Long> {
    Optional<Benefited> findByDocument(String document);
}
