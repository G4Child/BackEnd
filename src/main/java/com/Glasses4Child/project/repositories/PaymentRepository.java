package com.Glasses4Child.project.repositories;

import com.Glasses4Child.project.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}