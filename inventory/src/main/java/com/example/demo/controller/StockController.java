package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.service.StockService;

@Controller
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/add")
    public String addStock(@RequestParam int productId,
                           @RequestParam int quantity) {
        stockService.addStock(productId, quantity);
        return "redirect:/";
    }

    @PostMapping("/reduce")
    public String reduceStock(@RequestParam int productId,
                              @RequestParam int quantity) {
        stockService.reduceStock(productId, quantity);
        return "redirect:/";
    }
}