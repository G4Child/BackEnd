package com.Glass4Child.project.repositories;

import com.Glass4Child.project.entities.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository<Donation, Long> {
}