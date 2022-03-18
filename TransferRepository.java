package com.example.tosProject.repository;

import com.example.tosProject.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
    List<Transfer> findByTitleContains(String title);
    Transfer findByTitle(String title);
}
