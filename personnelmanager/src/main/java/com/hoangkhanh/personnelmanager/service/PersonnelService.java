package com.hoangkhanh.personnelmanager.service;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hoangkhanh.personnelmanager.exception.StorageException;
import com.hoangkhanh.personnelmanager.model.Job;
import com.hoangkhanh.personnelmanager.model.Personnel;
import com.hoangkhanh.personnelmanager.repository.PersonnelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;


@Service
public class PersonnelService {
    
    @Autowired
    private PersonnelRepository personnelRepo;

    @Value("${upload.path}")
    private String path;

    public void uploadFile(MultipartFile file) {

        if (file.isEmpty()) {
            throw new StorageException("Failed to store empty file");
        }

        String fileName = file.getOriginalFilename();
        try {
            var is = file.getInputStream();
            Files.copy(is, Paths.get(path + fileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            var msg = String.format("Failed to store file %s", fileName);
            throw new StorageException(msg, e);
        }
    }

    public void save( MultipartFile file, Personnel personnel) {
        uploadFile(file);
        personnel.setImage(file.getOriginalFilename());
        personnelRepo.save(personnel);
    }
    
    public List<Personnel> getAllPersonnels() {
        return personnelRepo.findAll();
    }

    public void deletePersonnelById(Long id) {
        personnelRepo.deleteById(id);
    }

    public Optional<Personnel> findById(Long id) {
        return personnelRepo.findById(id);
    }
}
