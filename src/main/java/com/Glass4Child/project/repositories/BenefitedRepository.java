package com.Glass4Child.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Glass4Child.project.entities.Benefited;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


public interface BenefitedRepository extends JpaRepository<Benefited, Long> {
//    Optional<Benefited> findByDocument(String document);

    Benefited findByDocument(String document);


    @Transactional
    @Modifying
    @Query("delete from Benefited where document = :document")
    void deleteByDocument(@Param("document") String document);

}