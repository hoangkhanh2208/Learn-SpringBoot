package com.hoangkhanh.controller;

import com.hoangkhanh.model.Category;
import com.hoangkhanh.repository.CategoryRepo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    private final CategoryRepo categoryRepo;

    public CategoryController(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }
    
    @GetMapping("/listcategory")
    public String listCategory(Model model) {
        model.addAttribute("categories", categoryRepo.findAll());
        return "list-category";
    }

    @GetMapping("/create-category")
    public String createCategory(Model model) {
        model.addAttribute("category", new Category());
        return "create-category";
    }

    @PostMapping("/create-category")
    public String createCategory(@ModelAttribute Category category) {
        categoryRepo.save(category);
        return "redirect:/listcategory";
    }
}
