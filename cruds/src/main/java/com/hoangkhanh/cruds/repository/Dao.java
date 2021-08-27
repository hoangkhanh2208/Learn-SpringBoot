package com.hoangkhanh.cruds.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.hoangkhanh.cruds.model.Person;

public abstract class Dao<T> {
    protected List<T> collections = new ArrayList<>();

    public abstract List<T> getAll();

    public abstract T add(T t);

    public abstract Optional<Person> findById(int id);

    public abstract void update(T t);

    public abstract void deleteByID(int id);

    public abstract void delete(T t);

    public abstract List<T> searchByKeyword(String keyword);

    // public abstract List<T> searchByName(String name);
}
