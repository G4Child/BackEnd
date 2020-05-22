package com.Glass4Child.project.services;

import com.Glass4Child.project.entities.Donate;
import com.Glass4Child.project.repositories.DonateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonateService {
    @Autowired
    private DonateRepository repository;

    public List<Donate> findAll() {
        return repository.findAll();
    }

    public Donate findById(Long id) {
        Optional<Donate> obj = repository.findById(id);
        return obj.get();
    }
}