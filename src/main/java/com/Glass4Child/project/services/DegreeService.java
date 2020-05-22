package com.Glass4Child.project.services;

import com.Glass4Child.project.entities.Degree;
import com.Glass4Child.project.repositories.DegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DegreeService {
    @Autowired
    private DegreeRepository repository;

    public List<Degree> findAll() {
        return repository.findAll();
    }

    public Degree findById(Long id) {
        Optional<Degree> obj = repository.findById(id);
        return obj.get();
    }
}