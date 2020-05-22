package com.Glass4Child.project.services;

import com.Glass4Child.project.entities.Glasses;
import com.Glass4Child.project.repositories.GlasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GlasseService {

    @Autowired
    private GlasseRepository repository;

    public List<Glasses> findAll() {
        return repository.findAll();
    }

    public Glasses findById(Long id) {
        Optional<Glasses> obj = repository.findById(id);
        return obj.get();
    }

}
