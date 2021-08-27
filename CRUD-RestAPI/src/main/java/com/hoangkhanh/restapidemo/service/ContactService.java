package com.hoangkhanh.restapidemo.service;

import com.hoangkhanh.restapidemo.model.Contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactService extends JpaRepository<Contact,Long>{
    
}
