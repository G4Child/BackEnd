package com.Glasses4Child.project.repositories;

import com.Glasses4Child.project.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {
}