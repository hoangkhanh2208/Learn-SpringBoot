package com.hoangkhanh.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.hoangkhanh.model.Person;

public abstract class Dao<T> {
    protected List<T> collections = new ArrayList<>();

    public abstract List<T> getAll();

    public abstract Optional<T> get(int id);

    public abstract void add(T t);

    public abstract void update(T t);

    public abstract void delete(T t);

    public abstract void deleteById(int id);
}
