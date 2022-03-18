package com.example.tosProject.controller;


import com.example.tosProject.model.FinOrgan;
import com.example.tosProject.service.FinOrganService;
import com.example.tosProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class FinOrganController {
   private final FinOrganService finOrganService;
   private final UserService userService;
    @GetMapping("/finorgans")
    public String finorgans(@RequestParam(name= "searchWord", required = false) String title,Principal principal, Model model){
        model.addAttribute("finorgans", finOrganService.listFinOrgan(title));
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("searchWord", title);
        return "finorgans";
    }

    @GetMapping("/finorgan/edit/{id}")
    public String finOrganEdit(@PathVariable("id")Long id, Model model, Principal principal){
        FinOrgan finOrgan=finOrganService.findById(id);
        model.addAttribute("finorgan", finOrgan);
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "finorgan-edit";
    }

    @PostMapping("/finorgan/edit/finorgan-edit/{id}")
    public String finOrganEdit(@RequestParam ("title") String title, @PathVariable("id") Long id){
        System.out.println("???????????????????????");
        FinOrgan finOrgan=finOrganService.findById(id);
        System.out.println(title);
        System.out.println(finOrgan.getId());
        finOrganService.correctFinOrgan(finOrgan,title);
        return "redirect:/finorgans";
    }

    @PostMapping("/finorgan/add")
    public String addFinOrgan(FinOrgan finOrgan, Principal principal){
        finOrganService.saveFinOrgan(finOrgan);
        return "redirect:/finorgans";
    }

    @GetMapping("/finorgan/delete/{id}")
    public String deleteFinOrgan(@PathVariable("id") Long id){
        System.out.println("-------------------------------");
        System.out.println(id);
        finOrganService.deleteFinOrgan(id);
        return "redirect:/finorgans";
    }
}
