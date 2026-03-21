package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.StockTransaction;

public interface StockTransactionRepository
        extends JpaRepository<StockTransaction, Integer> {
}