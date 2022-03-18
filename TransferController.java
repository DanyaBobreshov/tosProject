package com.example.tosProject.controller;

import com.example.tosProject.model.FinOrgan;
import com.example.tosProject.model.Transfer;
import com.example.tosProject.service.TransferService;
import com.example.tosProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class TransferController {
    private final TransferService transferService;
    private final UserService userService;
    @GetMapping("/transfers")
    public String transfers(@RequestParam(name= "searchWord", required = false) String title, Principal principal, Model model){
        model.addAttribute("transfers", transferService.list(title));
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("searchWord", title);
        return "transfers";
    }

    @GetMapping("/transfer/edit/{id}")
    public String transferEdit(@PathVariable("id")Long id, Model model, Principal principal){
        Transfer transfer= transferService.findById(id);
        model.addAttribute("transfer", transfer);
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "transfer-edit";
    }

    @PostMapping("/transfer/edit/transfer-edit/{id}")
    public String transferEdit(@RequestParam ("title") String title, @PathVariable("id") Long id){
        System.out.println("???????????????????????");
        Transfer transfer= transferService.findById(id);
        System.out.println(title);
        System.out.println(transfer.getId());
        transferService.correctTransfer(transfer,title);
        return "redirect:/transfers";
    }

    @PostMapping("/transfer/add")
    public String addFinOrgan(Transfer transfer, Principal principal){
        transferService.saveTransfer(transfer);
        return "redirect:/transfers";
    }

    @GetMapping("/transfer/delete/{id}")
    public String deletetransfer(@PathVariable("id") Long id){
        System.out.println("-------------------------------");
        System.out.println(id);
        transferService.deleteTransfer(id);
        return "redirect:/transfers";
    }

}
