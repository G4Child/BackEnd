package com.Glasses4Child.project.repositories;

import com.Glasses4Child.project.entities.Beneficent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface BeneficentRepository extends JpaRepository<Beneficent, String> {
    Beneficent findByDocument(String document);

    @Transactional
    @Modifying
    @Query("delete from Beneficent where document = :document")
    void deleteByDocument(@Param("document") String document);
}