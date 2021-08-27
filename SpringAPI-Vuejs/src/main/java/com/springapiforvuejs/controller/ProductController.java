package com.springapiforvuejs.controller;

import java.util.List;

import com.springapiforvuejs.model.Product;
import com.springapiforvuejs.repository.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductRepo productRepo;
    
    @GetMapping("/product")
    public List<Product> getAll() {
        return productRepo.getAll();
    }
}
