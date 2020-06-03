package com.Glasses4Child.project.resources;

import com.Glasses4Child.project.entities.Benefited;
import com.Glasses4Child.project.services.BenefitedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/benefiteds")
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
        if (obj == null){
            return ResponseEntity.notFound().build();
        }else
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Benefited> insert(@RequestBody Benefited obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getDocument()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{document}")
    public ResponseEntity<Void> delete(@PathVariable String document){
        service.delete(document);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{document}")
    public ResponseEntity<Benefited> update(@PathVariable String document, @RequestBody Benefited obj){
        obj = service.update(document, obj);
        return ResponseEntity.ok().body(obj);
    }
}