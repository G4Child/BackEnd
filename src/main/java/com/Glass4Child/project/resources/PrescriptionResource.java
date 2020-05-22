package com.Glass4Child.project.resources;

import com.Glass4Child.project.entities.Address;
import com.Glass4Child.project.entities.Prescription;
import com.Glass4Child.project.services.AddressService;
import com.Glass4Child.project.services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/Prescription")
public class PrescriptionResource {

    @Autowired
    private PrescriptionService service;

    @GetMapping
    public ResponseEntity<List<Prescription>> findAll() {

        List<Prescription> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Prescription> findByDocument(@PathVariable Long id) {
        Prescription obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}