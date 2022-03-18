package com.example.tosProject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Akt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDateTime date;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private Regiment base;
    //количество вновь поставляемого продукта (по созданию прибавить к продукту, массив: 1 элемент - первый продукт)
    //private ArrayList<Integer> amount;
    //v zelom bespoleznoe pole. legasy;

    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="akts_products",
            joinColumns = @JoinColumn(name="akt_id"),
            inverseJoinColumns = @JoinColumn(name="product_id"))
    private List<Product> products;



}
