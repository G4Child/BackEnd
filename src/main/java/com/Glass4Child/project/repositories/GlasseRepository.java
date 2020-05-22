package com.Glass4Child.project.repositories;

import com.Glass4Child.project.entities.Glasses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GlasseRepository extends JpaRepository<Glasses,Long> {
}
