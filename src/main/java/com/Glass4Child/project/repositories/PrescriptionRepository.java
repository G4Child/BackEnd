package com.Glass4Child.project.repositories;

import com.Glass4Child.project.entities.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}