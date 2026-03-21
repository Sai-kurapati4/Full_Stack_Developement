package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.example.demo.*;
import com.example.demo.repository.*;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StockTransactionRepository transactionRepository;

    // Add stock
    public Stock addStock(Integer productId, Integer quantity) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Optional<Stock> existingStock = stockRepository.findAll()
                .stream()
                .filter(s -> s.getProduct().getProductId().equals(productId))
                .findFirst();

        Stock stock;

        if (existingStock.isPresent()) {
            stock = existingStock.get();
            stock.setQuantityAvailable(stock.getQuantityAvailable() + quantity);
        } else {
            stock = new Stock();
            stock.setProduct(product);
            stock.setQuantityAvailable(quantity);
        }

        stock.setLastUpdated(LocalDateTime.now());
        stockRepository.save(stock);

        // Save transaction
        StockTransaction transaction = new StockTransaction();
        transaction.setProduct(product);
        transaction.setTransactionType("IN");
        transaction.setQuantity(quantity);
        transaction.setTransactionDate(LocalDateTime.now());

        transactionRepository.save(transaction);

        return stock;
    }

    // Reduce stock
    public Stock reduceStock(Integer productId, Integer quantity) {

        Stock stock = stockRepository.findAll()
                .stream()
                .filter(s -> s.getProduct().getProductId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Stock not found"));

        if (stock.getQuantityAvailable() < quantity) {
            throw new RuntimeException("Insufficient stock");
        }

        stock.setQuantityAvailable(stock.getQuantityAvailable() - quantity);
        stock.setLastUpdated(LocalDateTime.now());
        stockRepository.save(stock);

        // Save transaction
        StockTransaction transaction = new StockTransaction();
        transaction.setProduct(stock.getProduct());
        transaction.setTransactionType("OUT");
        transaction.setQuantity(quantity);
        transaction.setTransactionDate(LocalDateTime.now());

        transactionRepository.save(transaction);

        return stock;
    }
}