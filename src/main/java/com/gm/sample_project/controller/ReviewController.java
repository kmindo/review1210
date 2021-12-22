package com.gm.sample_project.controller;

import com.gm.sample_project.service.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {
    @Autowired ReviewService service;
    @GetMapping("/review")
    public String getReviewList(Model model,
    @RequestParam @Nullable String type,
    @RequestParam @Nullable String keyword,
    @RequestParam @Nullable Integer offset){
    model.addAttribute("data", service.getReviewList(type, keyword, offset));
    return "/review/list";
    }
}
