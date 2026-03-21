package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;

import com.example.demo.Supplier;
import com.example.demo.service.SupplierService;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public String addSupplier(Supplier supplier) {
        supplierService.saveSupplier(supplier);
        return "redirect:/";
    }
    }
