package com.Glasses4Child.project.resources;

import com.Glasses4Child.project.entities.Donation;
import com.Glasses4Child.project.services.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/donations")
public class DonationResource {
    @Autowired
    private DonationService service;

    @GetMapping
    public ResponseEntity<List<Donation>> findAll() {
        List<Donation> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Donation> findById(@PathVariable Long id) {
        Donation obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}