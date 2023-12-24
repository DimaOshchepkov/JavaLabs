package com.vyatsu.lab6.dao;

import com.vyatsu.lab6.models.Enrollee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrolleeListDao implements Dao<Enrollee>{
    private List<Enrollee> enrollees = new ArrayList<>();

    public EnrolleeListDao(EnrolleeDBDao enrolleeDBDao) {
        enrollees = enrolleeDBDao.getAll().stream().map(Enrollee::new).toList();
    }

    @Override
    public int size() {
        return enrollees.size();
    }

    @Override
    public Optional<Enrollee> get(int id) {
        return Optional.of(enrollees.get(id));
    }

    @Override
    public List<Enrollee> getAll() {
        return enrollees;
    }

    @Override
    public void save(Enrollee enrollee) {
        enrollees.add(enrollee);
    }

    @Override
    public void delete(Enrollee enrollee) {
        enrollees.remove(enrollee);
    }

}

