package com.gm.sample_project.controller;

import com.gm.sample_project.service.DashboardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired DashboardService service;
    @GetMapping("/")
    public String getMain(Model model){
        model.addAttribute("cnt", service.getCounts());
        return "/index";
    }
    
}
