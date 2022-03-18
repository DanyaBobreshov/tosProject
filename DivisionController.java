package com.example.tosProject.controller;

import com.example.tosProject.model.Division;
import com.example.tosProject.model.FinOrgan;
import com.example.tosProject.service.DivisionService;
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
public class DivisionController {
    private final DivisionService divisionService;
    private final UserService userService;

    @GetMapping("/divisions")
    public String divisions(@RequestParam(name= "searchWord", required = false) String title, Principal principal, Model model){
        model.addAttribute("divisions", divisionService.list(title));
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("searchWord", title);
        return "divisions";
    }

    @GetMapping("/division/edit/{id}")
    public String divisionEdit(@PathVariable("id")Long id, Model model, Principal principal){
        Division division=divisionService.findById(id);
        model.addAttribute("division", division);
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "division-edit";
    }

    @PostMapping("/division/edit/division-edit/{id}")
    public String divisionEdit(@RequestParam ("title") String title, @PathVariable("id") Long id){
        System.out.println("???????????????????????");
        Division division=divisionService.findById(id);
        System.out.println(title);
        System.out.println(division.getId());
        divisionService.correctDivision(division,title);
        return "redirect:/divisions";
    }

    @PostMapping("/division/add")
    public String addFinOrgan(Division division, Principal principal){
        divisionService.saveDivision(division);
        return "redirect:/divisions";
    }

    @GetMapping("/division/delete/{id}")
    public String deleteFinOrgan(@PathVariable("id") Long id){
        System.out.println("-------------------------------");
        System.out.println(id);
        divisionService.deleteDivision(id);
        return "redirect:/divisions";
    }
}
