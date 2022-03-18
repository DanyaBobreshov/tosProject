package com.example.tosProject.service;

import com.example.tosProject.model.Product;
import com.example.tosProject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> list(String title){
        if(title!=null)return productRepository.findByTitleContains(title);
        return productRepository.findAll();
    }

    public void saveProduct(Product product){
        log.info("save new Product");
        productRepository.save(product);
    }


    public Product findById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProduct(Long id){
        Product product = productRepository.findById(id).orElse(null);
        if(product!=null){
            productRepository.delete(product);
            log.info("Product with id = {} was deleted", id);

        }else {
            log.error("Product with id ={} is not found", id);
        }
    }

    public void correctProduct(Product product, String title, LocalDateTime dateOfAddToBase, Integer productAllInBase) {
        product.setTitle(title);
        product.setAllInBase(productAllInBase);
        product.setDateOfAddToBase(dateOfAddToBase);
        productRepository.save(product);
    }

    public Product findByTitle(String productTitle) {
        return productRepository.findByTitle(productTitle);
    }
}
