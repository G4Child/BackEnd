package com.Glasses4Child.project.services;

import com.Glasses4Child.project.entities.Payment;
import com.Glasses4Child.project.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository repository;

    public List<Payment> findAll() {
        return repository.findAll();
    }

    public Payment findById(Long id) {
        Optional<Payment> obj = repository.findById(id);
        return obj.get();
    }
}