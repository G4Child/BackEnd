package com.Glass4Child.project.services;

import com.Glass4Child.project.entities.GlassesStore;
import com.Glass4Child.project.repositories.GlassesStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GlassesStoreService {
    @Autowired
    private GlassesStoreRepository repository;

    public List<GlassesStore> findAll() {
        return repository.findAll();
    }

    public GlassesStore findById(Long id) {
        Optional<GlassesStore> obj = repository.findById(id);
        return obj.get();
    }
}