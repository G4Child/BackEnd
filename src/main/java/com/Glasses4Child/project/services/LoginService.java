package com.Glasses4Child.project.services;

import com.Glasses4Child.project.entities.Login;
import com.Glasses4Child.project.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private LoginRepository repository;

    public List<Login> findAll() {
        return repository.findAll();
    }

    public Login findById(Long id) {
        Optional<Login> obj = repository.findById(id);
        return obj.get();
    }
    public Login insert (Login obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Login update(Long id, Login obj){
        Login entityUpdate = repository.getOne(id);
        updateData(entityUpdate, obj);
        return repository.save(entityUpdate);
    }

    public void updateData (Login entity, Login obj){
        entity.setEmail(obj.getEmail());
        entity.setPassword(obj.getEmail());
    }
}
