package com.example.tosProject.repository;

import com.example.tosProject.model.Regiment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegimentRepository extends JpaRepository<Regiment, Long> {
    List<Regiment> findByTitleContains(String title);
    Regiment findByTitle(String title);
}
