package com.hoangkhanh.cruds.repository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.hoangkhanh.cruds.model.Person;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

@Repository
public class DaoPerson extends Dao<Person> {

    public DaoPerson() {
        // collections.add(new Person("Nguyễn Văn A", "Developer", "Female", 22/12/2004));
        // collections.add(new Person("Nguyễn Văn B", "Teacher", "Male", 22/08/2001));
        // collections.add(new Person("Nguyễn Văn C", "Developer", "Female", 22/08/2001));
    }

    @Override
    public List<Person> getAll() {
        return collections;
    }

    @Override
    public Person add(Person person) {
        // Cơ chế tự tăng
        int id;
        if (collections.isEmpty()) {
            id = 1;
        } else {
            Person lastPerson = collections.get(collections.size() - 1);
            id = lastPerson.getId() + 1;
        }
        person.setId(id);
        collections.add(person);
        return person;
    }

    @Override
    public void update(Person person) {
        findById(person.getId()).ifPresent(existperson -> {
            existperson.setName(person.getName());
            existperson.setJob(person.getJob());
            existperson.setGender(person.getGender());
            existperson.setBirthDay(person.getBirthDay());
        });
    }

    @Override
    public void deleteByID(int id) {
        findById(id).ifPresent(existperson -> collections.remove(existperson));
    }

    @Override
    public void delete(Person person) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Optional<Person> findById(int id) {
        return collections.stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public List<Person> searchByKeyword(String keyword) {
        return collections.stream()
                .filter(p -> p.matchWithKeyword(keyword))
                .collect(Collectors.toList());
    }

}
