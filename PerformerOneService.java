package com.example.tosProject.service;


import com.example.tosProject.model.PerformerOne;
import com.example.tosProject.repository.PerformerOneRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PerformerOneService {
    private final PerformerOneRepository performerOneRepository;

    public List<PerformerOne> list(String title){
        if(title!=null)return performerOneRepository.findByNameContains(title);
        return performerOneRepository.findAll();
    }

    public void savePerformerOne(PerformerOne performerOne){
        log.info("save new PerformerOne");
        performerOneRepository.save(performerOne);
    }

    public void correctPerformerOne(PerformerOne performerOne,String name, String rang){
        performerOne.setName(name);
        performerOne.setRang(rang);
        savePerformerOne(performerOne);
    }

    public PerformerOne findById(Long id){
        return performerOneRepository.findById(id).orElse(null);
    }

    public void deletePerformerOne(Long id){
        PerformerOne performerOne = performerOneRepository.findById(id).orElse(null);
        if(performerOne!=null){
            performerOneRepository.delete(performerOne);
            log.info("PerformerOne with id = {} was deleted", id);

        }else {
            log.error("PerformerOne with id ={} is not found", id);
        }
    }
}
