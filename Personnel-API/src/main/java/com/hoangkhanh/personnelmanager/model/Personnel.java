package com.hoangkhanh.personnelmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.hoangkhanh.personnelmanager.model.dto.PersonnelDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personnel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Job job;

    @Column(
            name = "gender",
            nullable = false
    )
    private String gender;

    @Column(
        name = "birth_day",
        nullable = false
    )
    private String birthDay;

    @Column(
        nullable = false
    )
    private String image;

    public static Personnel from(PersonnelDto personnelDto) {
        Personnel personnel = new Personnel();
        personnel.setName(personnelDto.getName());
        personnel.setGender(personnelDto.getGender());
        // personnel.setJob(personnelDto.getJob());
        personnel.setBirthDay(personnelDto.getBirthDay());
        personnel.setImage(personnelDto.getImage());
        return personnel;
    }
}
