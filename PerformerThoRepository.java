package com.example.tosProject.repository;

import com.example.tosProject.model.PerformerTho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerformerThoRepository extends JpaRepository<PerformerTho, Long> {
    List<PerformerTho> findByNameContains(String name);
    PerformerTho findByName(String title);
}
