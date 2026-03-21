package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

import com.example.demo.Product;
import com.example.demo.Supplier;
import com.example.demo.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public String addProduct(Product product,
                             @RequestParam("supplierId") Integer supplierId) {

        Supplier supplier = new Supplier();
        supplier.setSupplierId(supplierId);

        product.setSupplier(supplier);

        productService.saveProduct(product);

        return "redirect:/";
    }
    @GetMapping("/")
    public String dashboard() {
        return "dashboard";
    }
    @GetMapping("/all")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    }
