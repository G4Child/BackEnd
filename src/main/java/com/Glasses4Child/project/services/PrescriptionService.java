package com.Glasses4Child.project.services;

import com.Glasses4Child.project.entities.Prescription;
import com.Glasses4Child.project.repositories.PrescriptionRepository;
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
    public Prescription insert (Prescription obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Prescription update(Long id, Prescription obj){
        Prescription entityUpdate = repository.getOne(id);
        updateData(entityUpdate, obj);
        return repository.save(entityUpdate);
    }

    public void updateData (Prescription entity, Prescription obj){
        entity.setComments(obj.getComments());
        entity.setExamAttach(obj.getExamAttach());
    }
}