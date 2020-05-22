package com.Glass4Child.project.services;

import com.Glass4Child.project.entities.Address;
import com.Glass4Child.project.entities.Dependent;
import com.Glass4Child.project.repositories.AddressRepository;
import com.Glass4Child.project.repositories.DependentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DependentService {

    @Autowired
    private DependentRepository repository;

    public List<Dependent> findAll() {
        return repository.findAll();
    }

    public Dependent findById(Long id) {
        Optional<Dependent> obj = repository.findById(id);
        return obj.get();
    }



}
