package com.springapiforvuejs.model;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String name;
    private String specifications;
    private float price;
    private String image;
    
    public Product(String name, String specifications, float price, String image) {
        this.name = name;
        this.specifications = specifications;
        this.price = price;
        this.image = image;
    }
    
}
