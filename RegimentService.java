package com.example.tosProject.service;

import com.example.tosProject.model.Division;
import com.example.tosProject.model.FinOrgan;
import com.example.tosProject.model.Regiment;
import com.example.tosProject.repository.DivisionRepository;
import com.example.tosProject.repository.FinOrganRepository;
import com.example.tosProject.repository.RegimentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RegimentService {
    private final RegimentRepository regimentRepository;
    private final FinOrganRepository finOrganRepository;
    private final DivisionRepository divisionRepository;

    public List<Regiment> list(String title){
        if(title!=null)return regimentRepository.findByTitleContains(title);
        return regimentRepository.findAll();
    }

    public void saveRegiment(Regiment regiment){
        log.info("save new Regiment");
        regimentRepository.save(regiment);
    }


    public Regiment getRegimentById(Long id){
        return regimentRepository.findById(id).orElse(null);
    }

    public void deleteRegiment(Long id){
        Regiment regiment = regimentRepository.findById(id).orElse(null);
        if(regiment!=null){
            regiment.getDivision().getRegiments().remove(regiment);
            regiment.getFinOrgan().getRegiments().remove(regiment);
            regimentRepository.delete(regiment);
            log.info("Regiment with id = {} was deleted", id);

        }else {
            log.error("Regiment with id ={} is not found", id);
        }
    }

    public Regiment findById(Long id) {
        return regimentRepository.findById(id).orElse(null);
    }

    public void correctRegiment(Regiment regiment, String title, String name, String finOrgan, String division) {
        regiment.setTitle(title);
        regiment.setName(name);
        FinOrgan finOrganForData=finOrganRepository.findByTitle(finOrgan);
        if(finOrganForData!=null){
            finOrganForData.getRegiments().remove(regiment);
            finOrganForData.getRegiments().add(regiment);
            regiment.setFinOrgan(finOrganForData);
        }
        Division divisionForData=divisionRepository.findByTitle(division);
        if(divisionForData!=null){
            divisionForData.getRegiments().remove(regiment);
            divisionForData.getRegiments().add(regiment);
            regiment.setDivision(divisionForData);
        }

        regimentRepository.save(regiment);
    }
}