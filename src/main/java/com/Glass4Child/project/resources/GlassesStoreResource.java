package com.Glass4Child.project.resources;

import com.Glass4Child.project.entities.Benefited;
import com.Glass4Child.project.entities.Dependent;
import com.Glass4Child.project.entities.GlassesStore;
import com.Glass4Child.project.services.GlassesStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}