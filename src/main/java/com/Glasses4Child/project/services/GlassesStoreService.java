package com.Glasses4Child.project.services;

import com.Glasses4Child.project.entities.GlassesStore;
import com.Glasses4Child.project.repositories.GlassesStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GlassesStoreService {
    @Autowired
    private GlassesStoreRepository repository;

    public List<GlassesStore> findAll() {
        return repository.findAll();
    }

    public GlassesStore findById(Long id) {
        Optional<GlassesStore> obj = repository.findById(id);
        return obj.get();
    }

    public GlassesStore insert (GlassesStore obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public GlassesStore update(Long id, GlassesStore obj){
        GlassesStore entityUpdate = repository.getOne(id);
        updateData(entityUpdate, obj);
        return repository.save(entityUpdate);
    }

    public void updateData (GlassesStore entity, GlassesStore obj){
        entity.setActive(obj.isActive());
        entity.setTelephone(obj.getTelephone());
    }
}