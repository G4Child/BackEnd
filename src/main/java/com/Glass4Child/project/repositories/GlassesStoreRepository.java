package com.Glass4Child.project.repositories;

import com.Glass4Child.project.entities.GlassesStore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GlassesStoreRepository extends JpaRepository<GlassesStore,Long> {
    Optional<GlassesStore> findByDocument(String document);
}