package com.example.tosProject.controller;

import com.example.tosProject.model.Product;
import com.example.tosProject.model.Regiment;
import com.example.tosProject.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.sql.Date;
import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final UserService userService;
    private final AktService aktService;
    private final InvoiceService invoiceService;

    @GetMapping("/products")
    public String products(@RequestParam(name= "searchWord", required = false) String title, Principal principal, Model model){
        model.addAttribute("products", productService.list(title));
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("searchWord", title);
        return "products";
    }

    @GetMapping("/product/edit/{id}")
    public String productEdit(@PathVariable("id")Long id, Model model, Principal principal){
        Product product= productService.findById(id);
        model.addAttribute("product", product);
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "product-edit";
    }

    @PostMapping("/product/edit/product-edit/{id}")
    public String productsEdit(@RequestParam ("title") String title, @RequestParam ("dateOfAddToBase") Date dateOfAddToBaseSQL,
                               @RequestParam ("allInBase") Integer allInBase,
                               @PathVariable("id") Long id){
        System.out.println("???????????????????????");
        Product product= productService.findById(id);
        System.out.println(title);
        System.out.println(product.getId());
        LocalDateTime dateOfAddToBase=dateOfAddToBaseSQL.toLocalDate().atTime(12,0);
        productService.correctProduct(product,title, dateOfAddToBase, allInBase);
        return "redirect:/products";
    }

    @PostMapping("/product/add")
    public String addProduct(@RequestParam ("title") String title, @RequestParam ("dateOfAddToBase") Date dateOfAddToBaseSQL,
                              @RequestParam ("productAllInBase") Integer productAllInBase, Principal principal){
        LocalDateTime dateOfAddToBase= dateOfAddToBaseSQL.toLocalDate().atTime(10,0);
        Product product=new Product();
        productService.correctProduct(product,title, dateOfAddToBase, productAllInBase);
        return "redirect:/products";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        System.out.println("-------------------------------");
        System.out.println(id);
        productService.deleteProduct(id);
        return "redirect:/regiments";
    }

    @GetMapping("/product-akts/{id}")
    public String productsAkts(@PathVariable("id") Long id, Principal principal, Model model){
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("akts", productService.findById(id).getAkts());
        return "product-akts";
    }

    @GetMapping("/product-invoicesIn/{id}")
    public String productsAktsInvoices(@PathVariable("id") Long id, Principal principal, Model model){
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("invoices", productService.findById(id).getInvoicesIn());
        return "product-invoicesIn";
    }
}

