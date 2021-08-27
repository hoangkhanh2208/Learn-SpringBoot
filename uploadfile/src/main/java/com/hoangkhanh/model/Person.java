package com.hoangkhanh.model;

import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;


public class Person {
    private int id;
    @Size(min = 5, max = 30, message = "Name must between 5 and 30")
    private String name;
    private String job;
    private String gender;

    private String birthDay;
    private MultipartFile photo;
    private String pathPhoto;

    public Person() {
    }

    public Person(int id, String name, String job, String gender, String birthDay, String pathPhoto) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.gender = gender;
        this.birthDay = birthDay;
        this.pathPhoto = pathPhoto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPathPhoto() {
        return pathPhoto;
    }

    public void setPathPhoto(String pathPhoto) {
        this.pathPhoto = pathPhoto;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    
}
