package com.Glass4Child.project.resources;

import com.Glass4Child.project.entities.Benefited;
import com.Glass4Child.project.services.BenefitedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/benefited")
public class BenefitedResource {

    @Autowired
    private BenefitedService service;

    @GetMapping
    public ResponseEntity<List<Benefited>> findAll() {
        List<Benefited> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{document}")
    public ResponseEntity<Benefited> findByDocument(@PathVariable String document) {
        Benefited obj = service.findByDocument(document);
        return ResponseEntity.ok().body(obj);
    }
}