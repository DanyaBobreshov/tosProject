package com.example.tosProject.controller;

import com.example.tosProject.model.Akt;
import com.example.tosProject.model.Product;
import com.example.tosProject.model.Regiment;
import com.example.tosProject.service.AktService;
import com.example.tosProject.service.ProductService;
import com.example.tosProject.service.RegimentService;
import com.example.tosProject.service.UserService;
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
public class AktController {

    private final AktService aktService;
    private final UserService userService;
    private final ProductService productService;

    @GetMapping("/akts")
    public String products(@RequestParam(name= "searchWord", required = false) String title, Principal principal, Model model){
        model.addAttribute("akts", aktService.list(title));
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("searchWord", title);
        return "akts";
    }
    @GetMapping("/akt/products/{id}")
    public String aktProducts(@PathVariable("id")Long id, Model model, Principal principal){
        Akt akt= aktService.findById(id);
        model.addAttribute("akt", akt);
        model.addAttribute("products", akt.getProducts());
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "akt-products";
    }

    @PostMapping("/akt-products/add/{id}")
        public String addProductsForAkt(@RequestParam ("productTitle") String productTitle,
                                        @RequestParam ("productInAkt") Integer allInBase,
                                        @PathVariable("id") Long id){
        Akt akt= aktService.findById(id);
        Product product= productService.findByTitle(productTitle);
        product.setAllInBase(product.getAllInBase()+allInBase);
        productService.saveProduct(product);
        akt.getProducts().add(product);
        aktService.saveAkt(akt);
        return "redirect:/akt/products/"+id;
    }



    @GetMapping("/akt/edit/{id}")
    public String productEdit(@PathVariable("id")Long id, Model model, Principal principal){
        Akt akt= aktService.findById(id);
        model.addAttribute("akt", akt);
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "akt-edit";
    }

    @PostMapping("/akt/edit/akt-edit/{id}")
    public String aktEdit(@RequestParam ("title") String title, @RequestParam ("aktDate") Date aktDateSQL,
                               @RequestParam ("aktBase") String aktBase,
                               @PathVariable("id") Long id){
        System.out.println("???????????????????????");
        Akt akt= aktService.findById(id);
        System.out.println(title);
        System.out.println(akt.getId());
        LocalDateTime aktDate=aktDateSQL.toLocalDate().atTime(12,0);
        aktService.correctAkt(akt,title, aktDate, aktBase);
        return "redirect:/akts";
    }

    @PostMapping("/akt/add")
    public String addAkt(@RequestParam ("aktTitle") String title, @RequestParam ("aktDate") Date aktDateSQL,
                         @RequestParam ("aktRegiment") String aktBase, Principal principal){
        LocalDateTime date = aktDateSQL.toLocalDate().atTime(10,0);
        Akt akt=new Akt();
        aktService.correctAkt(akt,title, date, aktBase);
        return "redirect:/akts";
    }

    @GetMapping("/akt/delete/{id}")
    public String deleteAkt(@PathVariable("id") Long id){
        System.out.println("-------------------------------");
        System.out.println(id);
        aktService.deleteAkt(id);
        return "redirect:/akts";
    }

    @GetMapping("/akt-products/{id}")
    public String productsAkts(@PathVariable("id") Long id, Principal principal, Model model){
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("products", aktService.findById(id).getProducts());
        return "akt-products";
    }


}
