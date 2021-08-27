package com.hoangkhanh.personnelmanager.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.hoangkhanh.personnelmanager.model.Job;
import com.hoangkhanh.personnelmanager.model.exception.JobNotFoundException;
import com.hoangkhanh.personnelmanager.repository.JobRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    
    @Autowired
    private JobRepository jobRepo;

    public Job addJob(Job job) {
       return jobRepo.save(job);
    }

    public List<Job> getJobs() {
        return StreamSupport.stream(jobRepo.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Job getJob(Long id) {
        return jobRepo.findById(id).orElseThrow(() -> new JobNotFoundException(id));
    }

    public Job deleteJob(Long id) {
        Job job = getJob(id);
        jobRepo.deleteById(id);
        return job;
    }

    public Job editJob(Long id, Job job) {
        Job jobToEdit = getJob(id);
        jobToEdit.setName(job.getName());
        return jobToEdit;
    }
}
