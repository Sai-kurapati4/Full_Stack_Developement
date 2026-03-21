package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.ProductService;
import com.example.demo.entity.Product;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/getProducts")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/getProductByCost/{cost}")
    public Product getProductByCost(@PathVariable Double cost) {
        return service.getProductByCost(cost);
    }

    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable int id) {
        return service.getProduct(id);
    }

    @GetMapping("/getProductByName/{name}")
    public Product getProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @PostMapping("/addProduct")
    public Product addData(@RequestBody Product product) {
        service.addData(product);
        return product;
    }

    @PostMapping("/saveProduct")
    public ResponseEntity<Product> addDatap(@RequestBody Product product) {
        service.addData(product);
        return ResponseEntity.ok(product);
    }
}