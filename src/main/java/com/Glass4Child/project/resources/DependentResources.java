package com.Glass4Child.project.resources;

import com.Glass4Child.project.entities.Address;
import com.Glass4Child.project.entities.Dependent;
import com.Glass4Child.project.services.AddressService;
import com.Glass4Child.project.services.DependentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value = "/Dependent")
public class DependentResources {

    @Autowired
    private DependentService service;

    @GetMapping
    public ResponseEntity<List<Dependent>> findAll() {

        List<Dependent> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Dependent> findByDocument(@PathVariable Long id) {
        Dependent obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
