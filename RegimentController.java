package com.example.tosProject.controller;

import com.example.tosProject.model.FinOrgan;
import com.example.tosProject.model.Regiment;
import com.example.tosProject.service.DivisionService;
import com.example.tosProject.service.FinOrganService;
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

@Controller
@RequiredArgsConstructor
public class RegimentController {
    private final RegimentService regimentService;
    private final UserService userService;
    private final DivisionService divisionService;
    private final FinOrganService finOrganService;

    @GetMapping("/regiments")
    public String regiments(@RequestParam(name= "searchWord", required = false) String title, Principal principal, Model model){
        model.addAttribute("regiments", regimentService.list(title));
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("searchWord", title);
        return "regiments";
    }

    @GetMapping("/regiment/edit/{id}")
    public String regimentEdit(@PathVariable("id")Long id, Model model, Principal principal){
        Regiment regiment= regimentService.findById(id);
        model.addAttribute("regiment", regiment);
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "regiment-edit";
    }

    @PostMapping("/regiment/edit/regiment-edit/{id}")
    public String finOrganEdit(@RequestParam ("title") String title, @RequestParam ("name") String name,
                               @RequestParam ("finOrgan") String finOrgan, @RequestParam ("division") String division,
                               @PathVariable("id") Long id){
        System.out.println("???????????????????????");
        Regiment regiment= regimentService.findById(id);
        System.out.println(title);
        System.out.println(regiment.getId());
        regimentService.correctRegiment(regiment,title, name, finOrgan, division);
        return "redirect:/regiments";
    }

    @PostMapping("/regiment/add")
    public String addFinOrgan(@RequestParam ("title") String title, @RequestParam ("name") String name,
                              @RequestParam ("finOrgan") String finOrgan, @RequestParam ("division") String division, Principal principal){
        Regiment regiment=new Regiment();
        regimentService.correctRegiment(regiment, title, name, finOrgan, division);
        return "redirect:/regiments";
    }

    @GetMapping("/regiment/delete/{id}")
    public String deleteRegiment(@PathVariable("id") Long id){
        System.out.println("-------------------------------");
        System.out.println(id);
        regimentService.deleteRegiment(id);
        return "redirect:/regiments";
    }
}
