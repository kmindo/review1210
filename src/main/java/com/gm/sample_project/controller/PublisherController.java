package com.gm.sample_project.controller;

import java.util.Map;

import com.gm.sample_project.service.PublisherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PublisherController {
    @Autowired PublisherService service;
    @GetMapping("/publisher")
    public String getPublisher(Model model, @RequestParam @Nullable Integer offset){
        Map<String, Object> resultMap = service.getPublisherList(offset);
        model.addAttribute("data", resultMap);
        return "/publisher/list";
    }

}
