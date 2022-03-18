package com.example.tosProject.repository;

import com.example.tosProject.model.Akt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AktRepository extends JpaRepository<Akt, Long> {
    List<Akt> findByTitleContains(String title);
}
