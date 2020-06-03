package com.Glasses4Child.project.resources;

import com.Glasses4Child.project.entities.Login;
import com.Glasses4Child.project.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/logins")
public class LoginResource {
    @Autowired
    private LoginService service;

    @GetMapping
    public ResponseEntity<List<Login>> findAll() {
        List<Login> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Login> findById(@PathVariable Long id) {
        Login obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Login> insert(@RequestBody Login obj) {
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
    public ResponseEntity<Login> update (@PathVariable Long id, @RequestBody Login obj){
        obj = service.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }
}