package com.hoangkhanh.filmrestapi.model;

import lombok.Data;

public class Film {
    private String name;
    private String directors;
    private int year;
    public Film(String name, String directors, int year) {
        this.name = name;
        this.directors = directors;
        this.year = year;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDirectors() {
        return directors;
    }
    public void setDirectors(String directors) {
        this.directors = directors;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    
}
