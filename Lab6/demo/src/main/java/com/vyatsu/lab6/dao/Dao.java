package com.vyatsu.lab6.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    int size();
    Optional<T> get(int id);
    List<T> getAll();
    void save(T t);
    void delete(T t);
}
