package com.Glasses4Child.project.resources;

import com.Glasses4Child.project.entities.GlassesStore;
import com.Glasses4Child.project.services.GlassesStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/glassesStore")
public class GlassesStoreResource {
    @Autowired
    private GlassesStoreService service;

    @GetMapping
    public ResponseEntity<List<GlassesStore>> findAll() {
        List<GlassesStore> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GlassesStore> findById(@PathVariable Long id) {
        GlassesStore obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<GlassesStore> insert(@RequestBody GlassesStore obj) {
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
    public ResponseEntity<GlassesStore> update (@PathVariable Long id, @RequestBody GlassesStore obj){
        obj = service.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }
}