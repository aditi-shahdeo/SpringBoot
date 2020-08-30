package com.target.controllers;

import com.target.entity.Category;
import com.target.entity.Product;
import com.target.entity.Supplier;
import com.target.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin()
@RestController
@RequestMapping(path ="/api/products", produces ="application/json")
public class ProductController {

    @Autowired
    private ProductRepository repo;

    @Autowired
    private RestTemplate rt;

    @GetMapping
    public Iterable<Product> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Map<String, Object> getById(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();
        String url;
        ResponseEntity<?> resp;

        Product p = repo.findById(id).get();
        map.put("product", p);

        try {
            // we also should send a HTTP GET request for /api/categories/{p.categoryId}
            url = "http://localhost:3000/api/categories/" + p.getCategoryId();
            resp = rt.getForEntity(url, Category.class);
            map.put("category", resp.getBody());
        } catch (RestClientException e) {
            map.put("category-error", e.getMostSpecificCause());
        }

        try {
            // we also should send a HTTP GET request for /api/suppliers/{p.supplierId}
            url = "http://localhost:3200/api/suppliers/" + p.getSupplierId();
            resp = rt.getForEntity(url, Supplier.class);
            map.put("supplier", resp.getBody());
        } catch (RestClientException e) {
            map.put("supplier-error", e.getMessage());
        }

        return map;
    }
}