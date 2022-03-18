package com.example.tosProject.repository;

import com.example.tosProject.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DivisionRepository extends JpaRepository<Division, Long> {
    List<Division> findByTitleContains(String title);
    Division findByTitle(String title);
}
