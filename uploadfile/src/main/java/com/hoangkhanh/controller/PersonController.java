package com.hoangkhanh.controller;

import java.util.Optional;

import javax.validation.Valid;

import com.hoangkhanh.model.Person;
import com.hoangkhanh.repository.DaoPerson;
import com.hoangkhanh.service.StorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {
    @Autowired
    private DaoPerson daoPerson;

    @Autowired
    private StorageService storageService;

    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("persons", daoPerson.getAll());
        return "person";
    }
    
    @GetMapping("/person")
    public String addPerson(Model model) {
        model.addAttribute("person", new Person());
        return "addperson";
    }

    @PostMapping(value = "/person", consumes = { "multipart/form-data" } )
    public String addPerson(@Valid @ModelAttribute Person person, BindingResult result) {
        if (person.getPhoto().getOriginalFilename().isEmpty()) {
            result.addError(new FieldError("person", "photo", "Photo is required"));
        }
        
        if (result.hasErrors()) {
            return "addperson";
        }
        storageService.uploadFile(person.getPhoto());
        if (person.getId() > 0) { // Nếu có trường id có nghĩa là đây là edit form
            daoPerson.update(person);
        } else { // Nếu id ==0 có nghĩa book lần đầu được add new
            daoPerson.add(person);
        }
        return "redirect:/";
    }
    
    @GetMapping("/editperson/{id}")
    public String updatePerson(@PathVariable("id") int id, Model model, Person per, BindingResult result) {
        Optional<Person> person = daoPerson.get(id);
        if (person.isPresent()) {
            model.addAttribute("person", person.get());
        }
        if (!result.hasErrors()) {
            return "addperson";
        }
        return "redirect:/";
    }
    
    @PostMapping("/deleteperson/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        daoPerson.deleteById(id);
        return "redirect:/";
    }

    // @RequestMapping("/search")
    // public String searchByKeyword(@RequestParam(value = "keyword", required = false) String keyword, Model model) {      
    //     model.addAttribute("persons", daoPerson.searchByKeyword(keyword));
    //     model.addAttribute("key", keyword);
    //     return "person";
    // }

}
