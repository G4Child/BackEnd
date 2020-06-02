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
//        Optional<Benefited> obj = repository.findByDocument(document);
        Optional<Benefited> obj = Optional.ofNullable(repository.findByDocument(document));
        if (obj.isEmpty())
            return null;
        else
            return obj.get();
    }

    public Benefited insert(Benefited obj) {
        return repository.save(obj);
    }

    public void delete(String document) {
        repository.deleteByDocument(document);
    }

    public Benefited update(String document, Benefited obj) {
        Benefited objOld = repository.findByDocument(document);
//        updateData(objOld, obj);
        return repository.save(objOld);
    }
//
//    private void updateData(Benefited entity, Benefited obj) {
//        entity.getDocument()
//    }
}