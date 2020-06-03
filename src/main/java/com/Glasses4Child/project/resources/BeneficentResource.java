package com.Glasses4Child.project.resources;

import com.Glasses4Child.project.entities.Beneficent;
import com.Glasses4Child.project.services.BeneficentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/beneficents")
public class BeneficentResource {
    @Autowired
    private BeneficentService service;

    @GetMapping
    public ResponseEntity<List<Beneficent>> findAll() {
        List<Beneficent> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{document}")
    public ResponseEntity<Beneficent> findByDocument(@PathVariable String document) {
        Beneficent obj = service.findByDocument(document);
        if (obj == null) {
            return ResponseEntity.notFound().build();
        } else
            return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Beneficent> insert(@RequestBody Beneficent obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getDocument()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{document}")
    public ResponseEntity<Void> delete(@PathVariable String document){
        service.delete(document);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{document}")
    public ResponseEntity<Beneficent> update (@PathVariable String document, @PathVariable Beneficent obj){
        obj = service.update(document, obj);
        return ResponseEntity.ok().body(obj);
    }
}