package com.Glass4Child.project.repositories;

import com.Glass4Child.project.entities.Degree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DegreeRepository extends JpaRepository<Degree, Long> {
}