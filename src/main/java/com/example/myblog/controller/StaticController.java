package com.example.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticController {
    @GetMapping("/articles/privacy")
    public String privacy(Model model){
        model.addAttribute("msg", "안녕하세요, 여기는 privacy!");

        return "articles/privacy";
    }

    @GetMapping("/articles/terms")
    public String terms(Model model){
        model.addAttribute("msg", "안녕하세요, 여기는 terms!");
        return "articles/terms";
    }
}
