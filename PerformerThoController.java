package com.example.tosProject.controller;

import com.example.tosProject.model.PerformerOne;
import com.example.tosProject.model.PerformerTho;
import com.example.tosProject.service.PerformerThoService;
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
public class PerformerThoController {
    private final PerformerThoService performerThoService;
    private final UserService userService;

    @GetMapping("/performerThos")
    public String performerThos(@RequestParam(name= "searchWord", required = false) String title, Principal principal, Model model){
        model.addAttribute("performerthos", performerThoService.list(title));
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("searchWord", title);
        return "performerThos";
    }

    @GetMapping("/performerTho/edit/{id}")
    public String performerThoEdit(@PathVariable("id")Long id, Model model, Principal principal){
        PerformerTho performerTho= performerThoService.findById(id);
        model.addAttribute("performertho", performerTho);
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "performerTho-edit";
    }

    @PostMapping("performerTho/edit/performerTho-edit/{id}")
    public String performerThoEdit(@RequestParam ("name") String name, @RequestParam ("rang") String rang,
                                   @PathVariable("id") Long id){
        System.out.println("???????????????????????");
        PerformerTho performerTho= performerThoService.findById(id);
        performerThoService.correctPerformerTho(performerTho, name,rang);
        return "redirect:/performerThos";
    }

    @PostMapping("/performerTho/add")
    public String addFinOrgan(PerformerTho performerTho, Principal principal){
        performerThoService.savePerformerTho(performerTho);
        return "redirect:/performerThos";
    }

    @GetMapping("/performerTho/delete/{id}")
    public String deletePerformer(@PathVariable("id") Long id){
        System.out.println("-------------------------------");
        System.out.println(id);
        performerThoService.deletePerformerTho(id);
        return "redirect:/performerThos";
    }
}
