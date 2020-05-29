package com.Glass4Child.project.repositories;

import com.Glass4Child.project.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {
}