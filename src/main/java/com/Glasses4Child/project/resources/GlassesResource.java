package com.Glasses4Child.project.resources;

import com.Glasses4Child.project.entities.Glasses;
import com.Glasses4Child.project.services.GlassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/glasses")
public class GlassesResource {
    @Autowired
    private GlassesService service;

    @GetMapping
    public ResponseEntity<List<Glasses>> findAll() {
        List<Glasses> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Glasses> findById(@PathVariable Long id) {
        Glasses obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Glasses> insert(@RequestBody Glasses obj) {
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
    public ResponseEntity<Glasses> update (@PathVariable Long id, @RequestBody Glasses obj){
        obj = service.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }
}