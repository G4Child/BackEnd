package com.Glasses4Child.project.services;

import com.Glasses4Child.project.entities.Donation;
import com.Glasses4Child.project.repositories.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonationService {
    @Autowired
    private DonationRepository repository;

    public List<Donation> findAll() {
        return repository.findAll();
    }

    public Donation findById(Long id) {
        Optional<Donation> obj = repository.findById(id);
        return obj.get();
    }

    public Donation insert (Donation obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Donation update(Long id, Donation obj){
        Donation entityUpdate = repository.getOne(id);
        updateData(entityUpdate, obj);
        return repository.save(entityUpdate);
    }

    public void updateData (Donation entity, Donation obj){
        entity.setDeductedAmount(obj.getDeductedAmount());
    }
}