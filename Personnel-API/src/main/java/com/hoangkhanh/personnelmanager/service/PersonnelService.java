package com.hoangkhanh.personnelmanager.service;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hoangkhanh.personnelmanager.exception.StorageException;
import com.hoangkhanh.personnelmanager.model.Personnel;
import com.hoangkhanh.personnelmanager.model.exception.PersonnelNotFoundException;
import com.hoangkhanh.personnelmanager.repository.PersonnelRepository;

import org.springframework.beans.factory.annotation.Autowired;



@Service
public class PersonnelService {
    
    @Autowired
    private PersonnelRepository personnelRepo;

    // @Value("${upload.path}")
    // private String path;

    // public void uploadFile(MultipartFile file) {
    //     if (file.isEmpty()) {
    //         throw new StorageException("Failed to store empty file");
    //     }

    //     String fileName = file.getOriginalFilename();
    //     try {
    //         var is = file.getInputStream();
    //         Files.copy(is, Paths.get(path + fileName), StandardCopyOption.REPLACE_EXISTING);
    //     } catch (IOException e) {
    //         var msg = String.format("Failed to store file %s", fileName);
    //         throw new StorageException(msg, e);
    //     }
    // }

    public Personnel addPersonnel(Personnel personnel) {
        // uploadFile(file);
        // personnel.setImage(file.getOriginalFilename());
        return personnelRepo.save(personnel);
    }
    
    public List<Personnel> getPersonnels() {
        return StreamSupport
                .stream(personnelRepo.findAll().spliterator(), false)
                .collect(Collectors.toList()) ;
    }

    
    public Personnel getPersonnel(Long id) {
        return personnelRepo.findById(id).orElseThrow(() -> new PersonnelNotFoundException(id));
    }
    
    public Personnel deletePersonnel(Long id) {
        Personnel personnel = getPersonnel(id);
        personnelRepo.deleteById(id);
        return personnel;
    }

    public Personnel editPersonnel(Long id, Personnel personnel) {
        Personnel personnelToEdit = getPersonnel(id);
        personnelToEdit.setName(personnel.getName());
        personnelToEdit.setBirthDay(personnel.getBirthDay());
        personnelToEdit.setGender(personnel.getGender());
        personnelToEdit.setImage(personnel.getImage());
        return personnelToEdit;
    }
    
}
