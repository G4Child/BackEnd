package com.Glasses4Child.project.resources;

import com.Glasses4Child.project.entities.Record;
import com.Glasses4Child.project.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/records")
public class RecordResource {
    @Autowired
    private RecordService service;

    @GetMapping
    public ResponseEntity<List<Record>> findAll() {
        List<Record> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Record> findById(@PathVariable Long id) {
        Record obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}