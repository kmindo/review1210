package com.gm.sample_project.controller;

import com.gm.sample_project.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
    @Autowired EmployeeService service;
    @GetMapping("/employee")
    public String getEmployeeList(Model model,
    @RequestParam @Nullable String type,
    @RequestParam @Nullable String keyword,
    @RequestParam @Nullable Integer offset
    ){
        model.addAttribute("data", service.getEmployeeList(type, keyword, offset));
        return "/employee/list";
    }
}
