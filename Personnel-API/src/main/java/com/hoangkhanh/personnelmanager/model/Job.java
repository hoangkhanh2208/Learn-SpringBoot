package com.hoangkhanh.personnelmanager.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.hoangkhanh.personnelmanager.model.dto.JobDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
/*@Table(
        name = "job",
        uniqueConstraints = {
            @UniqueConstraint(name = "job_name_unique", columnNames = "name")
        }
)*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Personnel> personnels;

    public static Job from(JobDto jobDto) {
        Job job = new Job();
        job.setId(jobDto.getId());
        job.setName(jobDto.getName());
        // job.setPersonnels(jobDto.getPersonnels());
        return job;
    }
}
