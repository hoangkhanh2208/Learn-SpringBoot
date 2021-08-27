package com.hoangkhanh.cruds.controller;

import java.util.Optional;

import com.hoangkhanh.cruds.model.Person;
import com.hoangkhanh.cruds.repository.DaoPerson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @PostMapping("/person")
    public String addPerson(Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "addperson";
        }
        if (person.getId() > 0) { // Nếu có trường id có nghĩa là đây là edit form
            daoPerson.update(person);
        } else { // Nếu id ==0 có nghĩa book lần đầu được add new
            daoPerson.add(person);
        }
        return "redirect:/";
    }
    
    @GetMapping("/editperson/{id}")
    public String updatePerson(@PathVariable("id") int id, Model model, Person per, BindingResult result) {
        Optional<Person> person = daoPerson.findById(id);
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
        daoPerson.deleteByID(id);
        return "redirect:/";
    }

    @RequestMapping("/search")
    public String searchByKeyword(@RequestParam(value = "keyword", required = false) String keyword, Model model) {      
        model.addAttribute("persons", daoPerson.searchByKeyword(keyword));
        model.addAttribute("key", keyword);
        return "person";
    }

}
