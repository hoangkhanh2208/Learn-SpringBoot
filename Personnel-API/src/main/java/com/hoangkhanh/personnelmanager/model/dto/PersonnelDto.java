package com.hoangkhanh.personnelmanager.model.dto;

import java.util.Objects;

import com.hoangkhanh.personnelmanager.model.Job;
import com.hoangkhanh.personnelmanager.model.Personnel;

import lombok.Data;

@Data
public class PersonnelDto {
    private Long id;
    private String name;
    private JobXDto jobXDto;
    private String gender;
    private String birthDay;
    private String image;

    public static PersonnelDto from(Personnel personnel){
        PersonnelDto personnelDto = new PersonnelDto();
        personnelDto.setId(personnel.getId());
        personnelDto.setName(personnel.getName());
        personnelDto.setGender(personnel.getGender());
        personnelDto.setBirthDay(personnel.getBirthDay());
        personnelDto.setImage(personnel.getImage());
        if (Objects.nonNull(personnel.getJob())) {
            personnelDto.setJobXDto(JobXDto.from(personnel.getJob()));
        }
        return personnelDto;
    }
}
