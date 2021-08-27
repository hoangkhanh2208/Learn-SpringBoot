package com.hoangkhanh.personnelmanager.repository;

import com.hoangkhanh.personnelmanager.model.Personnel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Long>{
    
}
