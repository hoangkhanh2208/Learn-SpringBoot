package com.hoangkhanh.repository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.hoangkhanh.model.Person;

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
    public void add(Person person) {
        int id;
        if (collections.isEmpty()) {
            id = 1;
        } else {
            Person lastPerson = collections.get(collections.size() - 1);
            id = lastPerson.getId() + 1;
        }
        person.setId(id);
        person.setPathPhoto(person.getPhoto().getOriginalFilename());
        collections.add(person);
    }

    @Override
    public void update(Person person) {
        get(person.getId()).ifPresent(existPerson -> {
            existPerson.setName(person.getName());
            existPerson.setJob(person.getJob());
            existPerson.setGender(person.getGender());
            existPerson.setBirthDay(person.getBirthDay());
            existPerson.setPhoto(person.getPhoto());
            existPerson.setPathPhoto(person.getPhoto().getOriginalFilename());
        });
    }

    @Override
    public Optional<Person> get(int id) {
        return collections.stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public void deleteById(int id) {
        get(id).ifPresent(existPerson -> collections.remove(existPerson));
    }

    @Override
    public void delete(Person person) {
        // TODO Auto-generated method stub
        
    }

    // @Override
    // public Optional<Person> findById(int id) {
    //     return collections.stream().filter(p -> p.getId() == id).findFirst();
    // }

    // @Override
    // public List<Person> searchByKeyword(String keyword) {
    //     return collections.stream()
    //             .filter(p -> p.matchWithKeyword(keyword))
    //             .collect(Collectors.toList());
    // }

}
