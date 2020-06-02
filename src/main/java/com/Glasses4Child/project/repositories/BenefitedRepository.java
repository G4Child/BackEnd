package com.Glasses4Child.project.repositories;

import com.Glasses4Child.project.entities.Benefited;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


public interface BenefitedRepository extends JpaRepository<Benefited, String> {
    Benefited findByDocument(String document);

    @Transactional
    @Modifying
    @Query("delete from Benefited where document = :document")
    void deleteByDocument(@Param("document") String document);
}