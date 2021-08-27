package com.hoangkhanh.personnelmanager.controller;

import java.util.Optional;

import com.hoangkhanh.personnelmanager.model.Job;
import com.hoangkhanh.personnelmanager.model.Personnel;
import com.hoangkhanh.personnelmanager.service.JobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JobController {
    
    @Autowired
    private JobService jobService;

    @GetMapping("/listjob")
    public String getJob(Model model) {
        model.addAttribute("jobs", jobService.getAll());
        model.addAttribute("job", new Job());
        return "addjob";
    }

    @PostMapping("/listjob")
    public String saveJob(@ModelAttribute Job job) {
        jobService.save(job);
        return "redirect:/listjob";
    }

    @GetMapping("/editjob/{id}")
    public ModelAndView updatePerson(@PathVariable("id") Long id, Model model) {
        ModelAndView mav = new ModelAndView("addjob");
        Optional<Job> job = jobService.findById(id);
        if (job.isPresent()) {
            model.addAttribute("job", job.get());
        }
        return mav;
    }

    @PostMapping("/deletejob/{id}")
    public String deletePerson(@PathVariable("id") Long id) {
        jobService.deleteJobById(id);
        return "redirect:/listjob";
    }
}
