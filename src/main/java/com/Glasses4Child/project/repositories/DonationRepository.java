package com.Glasses4Child.project.repositories;

import com.Glasses4Child.project.entities.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository<Donation, Long> {
}