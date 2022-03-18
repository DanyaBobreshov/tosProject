package com.example.tosProject.service;

import com.example.tosProject.model.Division;
import com.example.tosProject.model.FinOrgan;
import com.example.tosProject.repository.DivisionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DivisionService {
    private final DivisionRepository divisionRepository;

    public List<Division> listDivision(String title){
        if(title!=null)return divisionRepository.findByTitleContains(title);
        return divisionRepository.findAll();
    }

    public void saveDivision(Division division){
        log.info("save new Division");
        divisionRepository.save(division);
    }

    public void correctDivision(Division division, String title){
        division.setTitle(title);
        divisionRepository.save(division);
    }

    public Division getDivisionById(Long id){
        return divisionRepository.findById(id).orElse(null);
    }

    public void deleteDivision(Long id){
        Division division = divisionRepository.findById(id).orElse(null);
        if(division!=null){
            divisionRepository.delete(division);
            log.info("division with id = {} was deleted", id);

        }else {
            log.error("division with id ={} is not found", id);
        }
    }

    public Object list(String title) {
        if(title!=null)return divisionRepository.findByTitleContains(title);
        return divisionRepository.findAll();    }

    public Division findById(Long id) {
        return divisionRepository.findById(id).orElse(null);
    }
}

