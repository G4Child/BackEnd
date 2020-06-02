package com.Glasses4Child.project.services;

import com.Glasses4Child.project.entities.Glasses;
import com.Glasses4Child.project.repositories.GlassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GlassesService {
    @Autowired
    private GlassesRepository repository;

    public List<Glasses> findAll() {
        return repository.findAll();
    }

    public Glasses findById(Long id) {
        Optional<Glasses> obj = repository.findById(id);
        return obj.get();
    }
}