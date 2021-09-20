package com.hoangkhanh.controller;

import com.hoangkhanh.repository.BrandRepo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BrandController {
    
    private final BrandRepo brandRepo;

    public BrandController(BrandRepo brandRepo) {
        this.brandRepo = brandRepo;
    }

    @GetMapping("/listbrand")
    public String listCategory(Model model) {
        model.addAttribute("brands", brandRepo.findAll());
        return "list-brand";
    }
}
