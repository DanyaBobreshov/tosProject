package com.example.tosProject.service;

import com.example.tosProject.model.*;
import com.example.tosProject.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final RegimentRepository regimentRepository;
    private final TransferRepository transferRepository;
    private final PerformerOneRepository performerOneRepository;
    private final PerformerThoRepository performerThoRepository;

    public List<Invoice> list(String title){
        if(title!=null)return invoiceRepository.findByTitleContains(title);
        return invoiceRepository.findAll();
    }

    public void saveInvoice(Invoice invoice){
        log.info("save new Invoice");
        invoiceRepository.save(invoice);
    }

    public void correctInvoice(Invoice invoice, String title, LocalDateTime dateOfCreate,
                               LocalDateTime dateOfPerformed, LocalDateTime dateOfOut,
                               String invoiceRegimentIn, String invoiceTransfer,
                               String invoicePerformerOne, String invoicePerformerTho){
        Regiment regiment = regimentRepository.findByTitle(invoiceRegimentIn);
        Transfer transfer = transferRepository.findByTitle(invoiceTransfer);
        PerformerOne performerOne= performerOneRepository.findByName(invoicePerformerOne);
        PerformerTho performerTho = performerThoRepository.findByName(invoicePerformerTho);
        invoice.setDateOfCreate(dateOfCreate);
        invoice.setDateOfPerformed(dateOfPerformed);
        invoice.setDateOfOut(dateOfOut);
        invoice.setTitle(title);
        invoice.setRegimentIn(regiment);
        invoice.setTransfer(transfer);
        invoice.setPerformerOne(performerOne);
        invoice.setPerformerTho(performerTho);
        saveInvoice(invoice);
    }

    public Invoice findById(Long id){
        return invoiceRepository.findById(id).orElse(null);
    }

    public void deleteFinOrgan(Long id){
        Invoice invoice = invoiceRepository.findById(id).orElse(null);
        if(invoice!=null){
            invoiceRepository.delete(invoice);
            log.info("Invoice with id = {} was deleted", id);

        }else {
            log.error("Invoice with id ={} is not found", id);
        }
    }
}
