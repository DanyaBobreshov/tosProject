package com.example.tosProject.controller;

import com.example.tosProject.model.Akt;
import com.example.tosProject.model.Invoice;
import com.example.tosProject.model.Product;
import com.example.tosProject.service.InvoiceService;
import com.example.tosProject.service.ProductService;
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
public class InvoiceController {
    private final InvoiceService invoiceService;
    private final UserService userService;
    private final ProductService productService;

    @GetMapping("/invoices")
    public String products(@RequestParam(name= "searchWord", required = false) String title, Principal principal, Model model){
        model.addAttribute("invoices", invoiceService.list(title));
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("searchWord", title);
        return "invoices";
    }
    @GetMapping("/invoice/products/{id}")
    public String aktProducts(@PathVariable("id")Long id, Model model, Principal principal){
        Invoice invoice= invoiceService.findById(id);
        model.addAttribute("invoice", invoice);
        model.addAttribute("products", invoice.getProducts());
        model.addAttribute("amounts", invoice.getProducts());
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "invoice-products";
    }

    @PostMapping("/invoice-products/add/{id}")
    public String addProductsForInvoice(@RequestParam ("productTitle") String productTitle,
                                    @RequestParam ("productAmount") Integer amountPr,
                                    @PathVariable("id") Long id){
        Invoice invoice= invoiceService.findById(id);
        Product product= productService.findByTitle(productTitle);
        invoice.getProducts().add(product);
        invoice.getAmount().add(amountPr);
        product.setAllInBase(product.getAllInBase()-amountPr);
        productService.correctProduct(product, product.getTitle(), product.getDateOfAddToBase(), product.getAllInBase());
        invoiceService.saveInvoice(invoice);
        return "redirect:/invoice/products/"+id;
    }



    @GetMapping("/invoice/edit/{id}")
    public String invoiceEdit(@PathVariable("id")Long id, Model model, Principal principal){
        Invoice invoice= invoiceService.findById(id);
        model.addAttribute("invoice", invoice);
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "invoice-edit";
    }

    @PostMapping("/invoice/edit/invoice-edit/{id}")
    public String invoiceEdit(@RequestParam ("invoiceTitle") String title, @RequestParam ("dateOfCreate") Date dateOfCreateSQL,
                              @RequestParam ("dateOfPerformed") Date dateOfPerformedSQL, @RequestParam ("dateOfOut") Date dateOfOutSQL,
                              @RequestParam ("invoiceRegimentIn") String invoiceRegimentIn, @RequestParam ("invoiceTransfer") String invoiceTransfer,
                              @RequestParam ("invoicePerformerOne") String invoicePerformerOne, @RequestParam ("invoicePerformerTho") String invoicePerformerTho,
                          @PathVariable("id") Long id){
        System.out.println("???????????????????????");
        Invoice invoice= invoiceService.findById(id);
        System.out.println(title);
        System.out.println(invoice.getId());
        LocalDateTime dateOfCreate=dateOfCreateSQL.toLocalDate().atTime(12,0);
        LocalDateTime dateOfPerformed=dateOfPerformedSQL.toLocalDate().atTime(12,0);
        LocalDateTime dateOfOut=dateOfOutSQL.toLocalDate().atTime(12,0);
        invoiceService.correctInvoice(invoice,title, dateOfCreate, dateOfPerformed, dateOfOut,
                                      invoiceRegimentIn, invoiceTransfer, invoicePerformerOne, invoicePerformerTho);
        return "redirect:/invoices";
    }

    @PostMapping("/invoice/ban/{id}")
    public String bun(@PathVariable("id")Long id){
       Invoice invoice=invoiceService.findById(id);
       invoice.setDateOfPerformed(LocalDateTime.now());
        return "redirect:/invoices";
    }

    @PostMapping("/invoice/add")
    public String addInvoice(@RequestParam ("invoiceTitle") String title,
                             @RequestParam ("invoiceRegimentIn") String invoiceRegimentIn,
                             @RequestParam ("invoiceTransfer") String invoiceTransfer,
                             @RequestParam ("invoicePerformerOne") String invoicePerformerOne,
                             @RequestParam ("invoicePerformerTho") String invoicePerformerTho){
        Invoice invoice=new Invoice();
        LocalDateTime dateOfCreate=LocalDateTime.now();
        LocalDateTime dateOfOut=LocalDateTime.now();
        dateOfOut.plusMonths(3);
        LocalDateTime dateOfPerformed=LocalDateTime.now();
        dateOfPerformed.plusMonths(3);
        invoiceService.correctInvoice(invoice,title, dateOfCreate, dateOfPerformed, dateOfOut,
                invoiceRegimentIn, invoiceTransfer, invoicePerformerOne, invoicePerformerTho);
        return "redirect:/invoices";
    }

    @GetMapping("/invoice/delete/{id}")
    public String deleteAkt(@PathVariable("id") Long id){
        System.out.println("-------------------------------");
        System.out.println(id);
        invoiceService.deleteFinOrgan(id);
        return "redirect:/invoices";
    }

    @GetMapping("/invoice-products/{id}")
    public String productInvoice(@PathVariable("id") Long id, Principal principal, Model model){
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("products", invoiceService.findById(id).getProducts());
        model.addAttribute("amounts", invoiceService.findById(id).getAmount());
        return "invoice-products";
    }


}
