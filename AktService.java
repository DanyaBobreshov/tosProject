package com.example.tosProject.service;

import com.example.tosProject.model.Akt;
import com.example.tosProject.model.Regiment;
import com.example.tosProject.repository.AktRepository;
import com.example.tosProject.repository.RegimentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AktService {
    private final AktRepository aktRepository;
    private final RegimentRepository regimentRepository;

    public List<Akt> list(String title){
        if(title!=null)return aktRepository.findByTitleContains(title);
        return aktRepository.findAll();
    }

    public void saveAkt(Akt akt){
    log.info("save new akt");
    aktRepository.save(akt);
    }

    public void correctAkt(Akt akt, String title, LocalDateTime date, String baseSt){
        Regiment base=regimentRepository.findByTitle(baseSt);
        akt.setTitle(title);
        akt.setDate(date);
        akt.setBase(base);
        saveAkt(akt);
    }


    public Akt findById(Long id){
        return aktRepository.findById(id).orElse(null);
    }

    public void deleteAkt(Long id){
        Akt akt = aktRepository.findById(id).orElse(null);
        if(akt!=null){
                aktRepository.delete(akt);
                log.info("akt with id = {} was deleted", id);

        }else {
            log.error("akt with id ={} is not found", id);
        }
    }
}
