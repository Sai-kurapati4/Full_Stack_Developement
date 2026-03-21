package com.example.demo.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Product;
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.name = ?1")
    Optional<Product> findByName(String name);

    @Query(value = "SELECT * FROM Product", nativeQuery = true)
    List<Product> findAll();

    Optional<Product> findByCost(double cost);
}
