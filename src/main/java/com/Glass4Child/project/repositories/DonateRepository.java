package com.Glass4Child.project.repositories;

import com.Glass4Child.project.entities.Donate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonateRepository extends JpaRepository<Donate, Long> {
}