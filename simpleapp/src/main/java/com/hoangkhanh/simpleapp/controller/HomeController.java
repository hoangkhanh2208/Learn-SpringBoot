package com.hoangkhanh.simpleapp.controller;

import com.hoangkhanh.simpleapp.repository.InMemoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private InMemoryRepository repo;

    @Autowired
    public HomeController(InMemoryRepository repo){
        this.repo = repo;
    } 

    @GetMapping("/")
    public String getHome(Model model) {
        boolean a = "aa".equals("dd");
        model.addAttribute("peoples", repo.getPeople());
        return "index";
    }
}