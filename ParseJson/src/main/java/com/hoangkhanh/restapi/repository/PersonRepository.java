package com.hoangkhanh.restapi.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hoangkhanh.restapi.model.Person;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

@Repository
public class PersonRepository {
    private ArrayList<Person> people = new ArrayList<>();

    /*
     * Nhiệm vụ của constructor này là đọc dữ liệu từ file JSON vào một
     * ArrayList<Person>
     */
    public PersonRepository() {
        try {
            File file = ResourceUtils.getFile("classpath:static/personsmall.json");
            ObjectMapper mapper = new ObjectMapper();
            // mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            people.addAll(mapper.readValue(file, new TypeReference<List<Person>>() {
            }));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Person> getAllPeople() {
        return people;
    }
}
