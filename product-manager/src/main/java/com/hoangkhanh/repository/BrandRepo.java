package com.hoangkhanh.repository;

import com.hoangkhanh.model.Brand;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepo extends JpaRepository<Brand, Long> {
    
}
