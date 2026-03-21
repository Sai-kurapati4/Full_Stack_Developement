package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.SupplierService;
import com.example.demo.service.ProductService;
@Controller
public class HomeController {

    @Autowired
    private SupplierService supplierService;
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        model.addAttribute("products", productService.getAllProducts());
        return "dashboard";
    }
}