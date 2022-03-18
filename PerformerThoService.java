package com.example.tosProject.service;


import com.example.tosProject.model.PerformerTho;
import com.example.tosProject.repository.PerformerThoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PerformerThoService {
    private final PerformerThoRepository performerThoRepository;

    public List<PerformerTho> list(String title){
        if(title!=null)return performerThoRepository.findByNameContains(title);
        return performerThoRepository.findAll();
    }

    public void savePerformerTho(PerformerTho performerTho){
        log.info("save new PerformerTho");
        performerThoRepository.save(performerTho);
    }

    public void correctPerformerTho(PerformerTho performerTho, String name, String rang){
        performerTho.setName(name);
        performerTho.setRang(rang);
        savePerformerTho(performerTho);
    }

    public PerformerTho findById(Long id){
        return performerThoRepository.findById(id).orElse(null);
    }

    public void deletePerformerTho(Long id){
        PerformerTho performerTho = performerThoRepository.findById(id).orElse(null);
        if(performerTho!=null){
            performerThoRepository.delete(performerTho);
            log.info("performerTho with id = {} was deleted", id);

        }else {
            log.error("performerTho with id ={} is not found", id);
        }
    }
}
