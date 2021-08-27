package com.hoangkhanh.run;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Film {
   
    private String title;
    private String description;
    private String director;
    private Integer year;

    public Film(String title, String description, String director, Integer year) {
        this.title = title;
        this.description = description;
        this.director = director;
        this.year = year;
    }

    public Film() {
    }

    
}
