package com.hoangkhanh.personnelmanager.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.hoangkhanh.personnelmanager.model.Job;
import com.hoangkhanh.personnelmanager.model.dto.JobDto;
import com.hoangkhanh.personnelmanager.service.JobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
@CrossOrigin("*")
public class JobController {
    
    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public ResponseEntity<JobDto> addJob(@RequestBody final JobDto jobDto) {
        Job job = jobService.addJob(Job.from(jobDto));
        return new ResponseEntity<>(JobDto.from(job), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<JobDto>> getJobs() {
        List<Job> jobs = jobService.getJobs();
        List<JobDto> jobDto = jobs.stream().map(JobDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(jobDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<JobDto> getPersonnel(@PathVariable final Long id) {
        Job job = jobService.getJob(id);
        return new ResponseEntity<>(JobDto.from(job), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<JobDto> deletePersonnel(@PathVariable final Long id) {
        Job job = jobService.deleteJob(id);
        return new ResponseEntity<>(JobDto.from(job), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<JobDto> editPersonnel(@PathVariable final Long id,
            @RequestBody final JobDto jobDto) {
        Job editedJob = jobService.editJob(id, Job.from(jobDto));
        return new ResponseEntity<>(JobDto.from(editedJob), HttpStatus.OK);
    }

    
}
