package com.hoangkhanh.personnelmanager.controller;

import java.util.Optional;

import com.hoangkhanh.personnelmanager.model.Job;
import com.hoangkhanh.personnelmanager.model.Personnel;
import com.hoangkhanh.personnelmanager.service.JobService;
import com.hoangkhanh.personnelmanager.service.PersonnelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonnelController {

    @Autowired
    private PersonnelService personnelSev;

    @Autowired
    private JobService jobService;

    @GetMapping("/")
    public String getHome() {
        return "home";
    }

    @GetMapping("/listpersonnel")
    public String getAllPersonnel(Model model){
        model.addAttribute("personnels", personnelSev.getAllPersonnels());
        return "listpersonnel";
    }
    
    @GetMapping("/addpersonnel")
    public String getForm(Model model) {
        model.addAttribute("personnel", new Personnel());
        model.addAttribute("job", new Job());
        model.addAttribute("jobs", jobService.getAll() );
        return "formaddpersonnel";
    }

    @PostMapping("/addpersonnel")
    public String addPersonnel(
            @ModelAttribute Personnel personnel, 
            @RequestParam(value = "filename") MultipartFile file
    ) 
    {
        personnelSev.save(file, personnel);
        return "redirect:/listpersonnel";
    }

    @GetMapping("/editpersonnel/{id}")
    public ModelAndView updatePerson(@PathVariable("id") Long id, Model model) {
        ModelAndView mav = new ModelAndView("formeditpersonnel");
        Optional<Personnel> personnel = personnelSev.findById(id);
        if (personnel.isPresent()) {
            model.addAttribute("personnel", personnel.get());
        }
        return mav;
    }

    @PostMapping("/deletepersonnel/{id}")
    public String deletePerson(@PathVariable("id") Long id) {
        personnelSev.deletePersonnelById(id);
        return "redirect:/listpersonnel";
    }
    
}
