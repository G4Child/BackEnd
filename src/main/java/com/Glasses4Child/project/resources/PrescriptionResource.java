package com.Glasses4Child.project.resources;

import com.Glasses4Child.project.entities.Prescription;
import com.Glasses4Child.project.services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/prescriptions")
public class PrescriptionResource {
    @Autowired
    private PrescriptionService service;

    @GetMapping
    public ResponseEntity<List<Prescription>> findAll() {

        List<Prescription> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Prescription> findById(@PathVariable Long id) {
        Prescription obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Prescription> insert(@RequestBody Prescription obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Prescription> update(@PathVariable Long id, @RequestBody Prescription obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}