package com.example.tosProject.controller;

import com.example.tosProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class CentralController {
    private final UserService userService;
    @GetMapping("/")
    public String central(Principal principal, Model model){
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "central";
    }
}
