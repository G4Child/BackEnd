package com.Glass4Child.project.services;

import java.util.List;
import java.util.Optional;
import com.Glass4Child.project.entities.Benefited;
import com.Glass4Child.project.repositories.BenefitedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BenefitedService {

    @Autowired
    private BenefitedRepository repository;

    public List<Benefited> findAll() {
        return repository.findAll();
    }

    public Benefited findByDocument(String document) {
        Optional<Benefited> obj = repository.findByDocument(document);
        return obj.get();
    }
}