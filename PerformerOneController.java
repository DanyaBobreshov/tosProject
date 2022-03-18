package com.example.tosProject.controller;

import com.example.tosProject.model.Division;
import com.example.tosProject.model.PerformerOne;
import com.example.tosProject.service.PerformerOneService;
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
public class PerformerOneController {
    private final PerformerOneService performerOneService;
    private final UserService userService;

    @GetMapping("/performerOnes")
    public String performerOnes(@RequestParam(name= "searchWord", required = false) String title, Principal principal, Model model){
        model.addAttribute("performerones", performerOneService.list(title));
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("searchWord", title);
        return "performerOnes";
    }

    @GetMapping("/performerOne/edit/{id}")
    public String performerOneEdit(@PathVariable("id")Long id, Model model, Principal principal){
        PerformerOne performerOne= performerOneService.findById(id);
        model.addAttribute("performerone", performerOne);
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "performerOne-edit";
    }

    @PostMapping("performerOne/edit/performerOne-edit/{id}")
    public String performerOneEdit(@RequestParam ("name") String name, @RequestParam ("rang") String rang,
                                   @PathVariable("id") Long id){
        System.out.println("???????????????????????");
        PerformerOne performerOne= performerOneService.findById(id);
        performerOneService.correctPerformerOne(performerOne, name,rang);
        return "redirect:/performerOnes";
    }

    @PostMapping("/performerOne/add")
    public String addFinOrgan(PerformerOne performerOne, Principal principal){
        performerOneService.savePerformerOne(performerOne);
        return "redirect:/performerOnes";
    }

    @GetMapping("/performerOne/delete/{id}")
    public String deleteFinOrgan(@PathVariable("id") Long id){
        System.out.println("-------------------------------");
        System.out.println(id);
        performerOneService.deletePerformerOne(id);
        return "redirect:/performerOnes";
    }


}
