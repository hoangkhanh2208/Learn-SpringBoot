package com.hoangkhanh.repository;

import com.hoangkhanh.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    
}
