package com.hoangkhanh.restapi.controller;

import java.util.List;

import com.hoangkhanh.restapi.model.Person;
import com.hoangkhanh.restapi.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("people")
    public ResponseEntity<List<Person>> getAllPeople(){
        return ResponseEntity.ok().body(personRepository.getAllPeople());
    }   
}
