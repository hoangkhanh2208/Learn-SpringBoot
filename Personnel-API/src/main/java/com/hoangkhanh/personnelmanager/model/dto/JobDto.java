package com.hoangkhanh.personnelmanager.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.hoangkhanh.personnelmanager.model.Job;
import com.hoangkhanh.personnelmanager.model.Personnel;

import lombok.Data;

@Data
public class JobDto {
    private Long id;
    private String name;
    private List<PersonnelDto> personnels = new ArrayList<>();

    public static JobDto from(Job job) {
        JobDto jobDto = new JobDto();
        jobDto.setId(job.getId());
        jobDto.setName(job.getName());
        jobDto.setPersonnels(job.getPersonnels().stream().map(PersonnelDto::from).collect(Collectors.toList()));
        return jobDto;
    }
}
