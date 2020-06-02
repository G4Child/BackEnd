package com.Glasses4Child.project.services;

import com.Glasses4Child.project.entities.Degree;
import com.Glasses4Child.project.repositories.DegreeRepository;
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

    public Degree insert (Degree obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Degree update(Long id, Degree obj){
        Degree entityUpdate = repository.getOne(id);
        updateData(entityUpdate, obj);
        return repository.save(entityUpdate);
    }

    public void updateData (Degree entity, Degree obj){
        entity.setAxis_L(obj.getAxis_L());
        entity.setAxis_R(obj.getAxis_R());
        entity.setCylinder_L(obj.getCylinder_L());
        entity.setCylinder_R(obj.getCylinder_R());
        entity.setSphere_L(obj.getSphere_L());
        entity.setSphere_R(obj.getSphere_R());
        entity.setPd_L(obj.getPd_L());
        entity.setPd_R(obj.getPd_R());
    }
}