package com.Glass4Child.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Glass4Child.project.entities.Beneficent;
import com.Glass4Child.project.repositories.BeneficentRepository;

@Service
public class BeneficentService {

    @Autowired
    private BeneficentRepository repository;

    public List<Beneficent> findAll() {
        return repository.findAll();
    }

    public Beneficent findByDocument(String document) {
        Optional<Beneficent> obj = repository.findByDocument(document);
        return obj.get();
    }
}