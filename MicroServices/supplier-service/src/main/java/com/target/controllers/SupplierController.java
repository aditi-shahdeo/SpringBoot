package com.target.controllers;

import com.target.entity.Supplier;
import com.target.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/suppliers", produces ="application/json")
public class SupplierController {
    @Autowired
    private SupplierRepository repo;

    @GetMapping
    public Iterable<Supplier> getAll(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Supplier getById(@PathVariable Integer id){
        return repo.findById(id).get();
    }
}