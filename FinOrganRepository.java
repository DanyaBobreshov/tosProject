package com.example.tosProject.repository;

import com.example.tosProject.model.FinOrgan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinOrganRepository extends JpaRepository<FinOrgan, Long> {
    List<FinOrgan> findByTitleContains(String title);
    FinOrgan findByTitle(String title);
}