package com.Glass4Child.project.services;

import com.Glass4Child.project.entities.GlassesStore;
import com.Glass4Child.project.entities.Login;
import com.Glass4Child.project.repositories.GlassesStoreRepository;
import com.Glass4Child.project.repositories.LoginRepository;
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
}
