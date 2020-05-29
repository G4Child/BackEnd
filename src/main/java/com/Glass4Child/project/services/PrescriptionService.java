package com.Glass4Child.project.services;

import com.Glass4Child.project.entities.Prescription;
import com.Glass4Child.project.repositories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService {
    @Autowired
    private PrescriptionRepository repository;

    public List<Prescription> findAll() {
        return repository.findAll();
    }

    public Prescription findById(Long id) {
        Optional<Prescription> obj = repository.findById(id);
        return obj.get();
    }
}