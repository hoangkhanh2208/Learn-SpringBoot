package com.hoangkhanh.controller;

import java.util.List;
import java.util.Optional;

import com.hoangkhanh.model.Product;
import com.hoangkhanh.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepo;
    
    @GetMapping("/list-product")
    public String getAllProduct(Model model) {
        List<Product> listProduct = productRepo.findAll();
        model.addAttribute("products", listProduct);
        return "list-product";
    }

    @GetMapping("/create-product")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "create-product";
    }

    @PostMapping("/create-product")
    public String addProduct(@ModelAttribute Product product) {
        productRepo.save(product);
        return "redirect:/list-product";
    }

    @GetMapping("edit-product/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model) {
        Optional<Product> product = productRepo.findById(id);
        model.addAttribute("product", product.get());
        return "edit-product";
    }

    @PostMapping("edit-product")
    public String editProduct(@ModelAttribute Product product) {
        Product productEdit = new Product();
        productEdit.setId(product.getId());
        productEdit.setName(product.getName());
        productEdit.setBrand(product.getBrand());
        productEdit.setMadeIn(product.getMadeIn());
        productEdit.setPrice(product.getPrice());
        productRepo.save(productEdit);
        return "redirect:/list-product";
    }

    @GetMapping("delete-product/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productRepo.deleteById(id);
        return "redirect:/list-product";
    }
}
