package com.example.tosProject.model;

import com.example.tosProject.service.ProductService;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateOfCreate;
    private LocalDateTime dateOfPerformed;
    private LocalDateTime dateOfOut;
    private String title;

    //пока пропустим пункт часть - отправитель. Несмотря на важность этого поля к его реализации я пока не готов
    //@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
   // @JoinColumn
   // Regiment regimentOut;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    Regiment regimentIn;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    Transfer transfer;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    PerformerOne performerOne;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    PerformerTho performerTho;

    @ManyToMany
    @JoinTable(name="invoice_products",
            joinColumns = @JoinColumn(name="invoice_id"),
            inverseJoinColumns = @JoinColumn(name="product_id"))
    private List<Product> products;

    //количество передаваемого продукта (по созданию отнять от продукта, массив: 1 элемент - первый продукт)
    private ArrayList<Integer> amount;

    }
