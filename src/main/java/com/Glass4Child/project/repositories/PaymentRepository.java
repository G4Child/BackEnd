package com.Glass4Child.project.repositories;

import com.Glass4Child.project.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}