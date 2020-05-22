package com.Glass4Child.project.resources;

import com.Glass4Child.project.entities.Donate;
import com.Glass4Child.project.entities.Prescription;
import com.Glass4Child.project.services.DonateService;
import com.Glass4Child.project.services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/Donate")
public class DonateResource {

    @Autowired
    private DonateService service;

    @GetMapping
    public ResponseEntity<List<Donate>> findAll() {

        List<Donate> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Donate> findByDocument(@PathVariable Long id) {
        Donate obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
