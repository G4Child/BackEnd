package com.Glasses4Child.project.resources;

import com.Glasses4Child.project.entities.Login;
import com.Glasses4Child.project.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}