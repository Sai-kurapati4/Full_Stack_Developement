package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.demo.StockTransaction;
import com.example.demo.repository.StockTransactionRepository;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private StockTransactionRepository transactionRepository;

    @GetMapping
    public List<StockTransaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}