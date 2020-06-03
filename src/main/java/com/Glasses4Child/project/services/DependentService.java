package com.Glasses4Child.project.services;

import com.Glasses4Child.project.entities.Dependent;
import com.Glasses4Child.project.repositories.DependentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Dependent insert (Dependent obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Dependent update(Long id, Dependent obj){
        Dependent entityUpdate = repository.getOne(id);
        updateData(entityUpdate, obj);
        return repository.save(entityUpdate);
    }

    public void updateData (Dependent entity, Dependent obj){
        entity.setActive(obj.isActive());
        entity.setPseudonym(obj.getPseudonym());
    }
}