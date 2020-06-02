package com.Glasses4Child.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Glasses4Child.project.entities.Beneficent;
import com.Glasses4Child.project.repositories.BeneficentRepository;

@Service
public class BeneficentService {
    @Autowired
    private BeneficentRepository repository;

    public List<Beneficent> findAll() {
        return repository.findAll();
    }

    public Beneficent findByDocument(String document) {
        Optional<Beneficent> obj = Optional.ofNullable(repository.findByDocument(document));
        if (obj.isEmpty())
            return null;
        else
            return obj.get();
    }

    public Beneficent insert(Beneficent obj) {
        return repository.save(obj);
    }

    public void delete(String document) {
        repository.deleteByDocument(document);
    }

    public Beneficent update(String document, Beneficent objectToUpdate) {
        Beneficent entityUpdate = repository.findByDocument(document);
        updateData(entityUpdate, objectToUpdate);
        return repository.save(entityUpdate);
    }

    private void updateData (Beneficent entity, Beneficent obj){
        entity.setDonationLimit(obj.getDonationLimit());
        entity.setTotalDonated(obj.getTotalDonated());
        entity.setEverDonated(obj.getEverDonated());
        entity.setActive(obj.isActive());
        entity.setTelephone(obj.getTelephone());
    }
}