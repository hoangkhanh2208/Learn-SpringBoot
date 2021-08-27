package com.hoangkhanh.personnelmanager.service;

import java.util.List;
import java.util.Optional;

import com.hoangkhanh.personnelmanager.model.Job;
import com.hoangkhanh.personnelmanager.repository.JobRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    
    @Autowired
    private JobRepository jobRepo;

    public void save(Job job) {
        jobRepo.save(job);
    }

    public List<Job> getAll() {
        return jobRepo.findAll();
    }

    public void deleteJobById(Long id) {
        jobRepo.deleteById(id);
    }

    public Optional<Job> findById(Long id) {
        return jobRepo.findById(id);
    }
}
