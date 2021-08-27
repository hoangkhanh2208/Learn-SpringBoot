package com.hoangkhanh.personnelmanager.model.dto;

import com.hoangkhanh.personnelmanager.model.Job;

import lombok.Data;

@Data
public class JobXDto {
    private Long id;
    private String name;

    public static JobXDto from(Job job) {
        JobXDto jobXDto = new JobXDto();
        jobXDto.setId(job.getId());
        jobXDto.setName(job.getName());
        return jobXDto;
    }
}
