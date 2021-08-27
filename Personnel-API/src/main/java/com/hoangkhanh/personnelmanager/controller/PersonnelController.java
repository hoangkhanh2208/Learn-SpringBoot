package com.hoangkhanh.personnelmanager.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.hoangkhanh.personnelmanager.model.Personnel;
import com.hoangkhanh.personnelmanager.model.dto.PersonnelDto;
import com.hoangkhanh.personnelmanager.service.PersonnelService;

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
@RequestMapping("/personnels")
@CrossOrigin("*")
public class PersonnelController {
    
    private final PersonnelService personnelSev;

    @Autowired
    public PersonnelController(PersonnelService personnelSev) {
        this.personnelSev = personnelSev;
    }


    @PostMapping
    public ResponseEntity<PersonnelDto> addPersonnel(@RequestBody final PersonnelDto personnelDto) {
        Personnel personnel = personnelSev.addPersonnel(Personnel.from(personnelDto));
        return new ResponseEntity<>(PersonnelDto.from(personnel), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PersonnelDto>> getPersonnels() {
        List<Personnel> personnels = personnelSev.getPersonnels();
        List<PersonnelDto> personnelDto = personnels.stream().map(PersonnelDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(personnelDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<PersonnelDto> getPersonnel(@PathVariable final Long id) {
        Personnel personnel = personnelSev.getPersonnel(id);
        return new ResponseEntity<>(PersonnelDto.from(personnel), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<PersonnelDto> deletePersonnel(@PathVariable final Long id) {
        Personnel personnel = personnelSev.deletePersonnel(id);
        return new ResponseEntity<>(PersonnelDto.from(personnel), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<PersonnelDto> editPersonnel(@PathVariable final Long id,
                                            @RequestBody final PersonnelDto personnelDto) {
        Personnel editedPersonnel = personnelSev.editPersonnel(id, Personnel.from(personnelDto));
        return new ResponseEntity<>(PersonnelDto.from(editedPersonnel), HttpStatus.OK);
    }

}
