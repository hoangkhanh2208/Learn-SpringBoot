package com.hoangkhanh.cruds.model;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Person {
    // private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String name;
    private String job;
    private String gender;
    private String birthDay;

    public boolean matchWithKeyword(String keyword) {
        String keywordLowerCase = keyword.toLowerCase();
        return name.toLowerCase().contains(keywordLowerCase);
    }
}
