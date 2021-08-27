package com.hoangkhanh.personnelmanager.repository;

import com.hoangkhanh.personnelmanager.model.Personnel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelRepository extends CrudRepository<Personnel, Long>{
    
}
