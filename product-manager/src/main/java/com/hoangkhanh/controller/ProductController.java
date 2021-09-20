package com.hoangkhanh.controller;

import com.hoangkhanh.repository.ProductRepo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    private final ProductRepo productRepo;

    public ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping("/")
    public String homePage() {
        return "home-page";
    }

    @GetMapping("/listproduct")
    public String listProduct(Model model) {
        model.addAttribute("products", productRepo.findAll());
        return "list-product";
    }
}
