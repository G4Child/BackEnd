package com.Glasses4Child.project.resources;

import com.Glasses4Child.project.entities.Degree;
import com.Glasses4Child.project.services.DegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/degrees")
public class DegreeResource {
    @Autowired
    private DegreeService service;

    @GetMapping
    public ResponseEntity<List<Degree>> findAll() {
        List<Degree> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Degree> findById(@PathVariable Long id) {
        Degree obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<Degree> insert(@RequestBody Degree obj) {
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
    public ResponseEntity<Degree> update (@PathVariable Long id, @RequestBody Degree obj){
        obj = service.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }
}