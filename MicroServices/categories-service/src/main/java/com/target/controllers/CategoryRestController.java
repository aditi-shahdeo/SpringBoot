package com.target.controllers;

import com.target.entity.Category;
import com.target.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/categories", produces = "application/json")
public class CategoryRestController {

    @Autowired
    private CategoryRepository repo;

    @GetMapping("/{id}")
    public Category getById(@PathVariable Integer id) {
        return repo.findById(id).get();
    }

    @GetMapping
    public Iterable<Category> getAll() {
        return repo.findAll();
    }
}