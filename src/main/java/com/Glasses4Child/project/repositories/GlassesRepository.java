package com.Glasses4Child.project.repositories;

import com.Glasses4Child.project.entities.Glasses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GlassesRepository extends JpaRepository<Glasses,Long> {
}