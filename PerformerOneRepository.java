package com.example.tosProject.repository;

import com.example.tosProject.model.PerformerOne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerformerOneRepository extends JpaRepository<PerformerOne, Long> {
    List<PerformerOne> findByNameContains(String name);
    PerformerOne findByName(String title);
}
