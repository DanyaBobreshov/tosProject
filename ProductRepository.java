package com.example.tosProject.repository;

import com.example.tosProject.model.PerformerTho;
import com.example.tosProject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitleContains(String title);

    Product findByTitle(String productTitle);
}
