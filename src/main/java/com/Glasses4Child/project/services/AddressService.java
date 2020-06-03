package com.Glasses4Child.project.services;

import com.Glasses4Child.project.entities.Address;
import com.Glasses4Child.project.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository repository;

    public List<Address> findAll() {
        return repository.findAll();
    }

    public Address findById(Long id) {
        Optional<Address> obj = repository.findById(id);
        return obj.get();
    }
    public Address insert (Address obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Address update(Long id, Address obj){
        Address entityUpdate = repository.getOne(id);
        updateData(entityUpdate, obj);
        return repository.save(entityUpdate);
    }

    public void updateData (Address entity, Address obj){
        entity.setCity(obj.getCity());
        entity.setComplement(obj.getComplement());
        entity.setNeighborhood(obj.getNeighborhood());
        entity.setNumber(obj.getNumber());
        entity.setState(obj.getState());
        entity.setStreetAddress(obj.getStreetAddress());
        entity.setReference(obj.getReference());
    }
}