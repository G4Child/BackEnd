package com.Glasses4Child.project.resources;

import com.Glasses4Child.project.entities.Dependent;
import com.Glasses4Child.project.services.DependentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/dependents")
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

    @PostMapping
    public ResponseEntity<Dependent> insert(@RequestBody Dependent obj) {
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
    public ResponseEntity<Dependent> update (@PathVariable Long id, @RequestBody Dependent obj){
        obj = service.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }
}