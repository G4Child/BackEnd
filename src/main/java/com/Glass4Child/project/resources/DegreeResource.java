package com.Glass4Child.project.resources;

import com.Glass4Child.project.entities.Degree;
import com.Glass4Child.project.services.DegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/degrees")
public class DegreeResouce {
    @Autowired
    private DegreeService service;

    @GetMapping
    public ResponseEntity<List<Degree>> findAll() {
        List<Degree> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Degree> findByDocument(@PathVariable Long id) {
        Degree obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}