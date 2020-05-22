package com.Glass4Child.project.services;

import com.Glass4Child.project.entities.Record;
import com.Glass4Child.project.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordService {
    @Autowired
    private RecordRepository repository;

    public List<Record> findAll() {
        return repository.findAll();
    }

    public Record findById(Long id) {
        Optional<Record> obj = repository.findById(id);
        return obj.get();
    }
}