package com.example.tosProject.service;

import com.example.tosProject.model.Transfer;
import com.example.tosProject.repository.TransferRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TransferService {
    private final TransferRepository transferRepository;

    public List<Transfer> list(String title){
        if(title!=null)return transferRepository.findByTitleContains(title);
        return transferRepository.findAll();
    }

    public void saveTransfer(Transfer transfer){
        log.info("save new Transfer");
        transferRepository.save(transfer);
    }

    public void correctTransfer(Transfer transfer, String title){
        transfer.setTitle(title);
        saveTransfer(transfer);
    }

    public Transfer findById(Long id){
        return transferRepository.findById(id).orElse(null);
    }

    public void deleteTransfer(Long id){
        Transfer transfer = transferRepository.findById(id).orElse(null);
        if(transfer!=null){
            transferRepository.delete(transfer);
            log.info("Transfer with id = {} was deleted", id);

        }else {
            log.error("Transfer with id ={} is not found", id);
        }
    }
}