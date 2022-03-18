package com.example.tosProject.service;

import com.example.tosProject.model.FinOrgan;
import com.example.tosProject.repository.FinOrganRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FinOrganService {
    private final FinOrganRepository finOrganRepository;

    public List<FinOrgan> listFinOrgan(String title){
        if(title!=null)return finOrganRepository.findByTitleContains(title);
        return finOrganRepository.findAll();
    }

    public void saveFinOrgan(FinOrgan finOrgan){
        log.info("save new FinOrgan");
        finOrganRepository.save(finOrgan);
    }

    public void correctFinOrgan(FinOrgan finOrgan, String title){
        finOrgan.setTitle(title);
        finOrganRepository.save(finOrgan);
    }

    public FinOrgan getFinOrganById(Long id){
        return finOrganRepository.findById(id).orElse(null);
    }

    public void deleteFinOrgan(Long id){
        FinOrgan finOrgan = finOrganRepository.findById(id).orElse(null);
        if(finOrgan!=null){
            finOrganRepository.delete(finOrgan);
            log.info("FinOrgan with id = {} was deleted", id);

        }else {
            log.error("FinOrgan with id ={} is not found", id);
        }
    }

    public void changeFinOrganEdit(FinOrgan finOrgan) {
    }

    public FinOrgan findById(Long id){
        return finOrganRepository.findById(id).orElse(null);
    }
}