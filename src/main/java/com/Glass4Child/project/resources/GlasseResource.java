package com.Glass4Child.project.resources;

import com.Glass4Child.project.entities.Glasses;
import com.Glass4Child.project.services.GlasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/Glasse")
public class GlasseResource {


    @Autowired
    private GlasseService service;

    @GetMapping
    public ResponseEntity<List<Glasses>> findAll() {

        List<Glasses> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Glasses> findByDocument(@PathVariable Long id) {
        Glasses obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
