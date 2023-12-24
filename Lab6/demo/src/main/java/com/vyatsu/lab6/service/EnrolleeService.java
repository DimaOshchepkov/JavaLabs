package com.vyatsu.lab6.service;

import com.vyatsu.lab6.dao.Dao;
import com.vyatsu.lab6.dao.EnrolleeDBDao;
import com.vyatsu.lab6.entity.EnrolleeEntity;
import com.vyatsu.lab6.models.Enrollee;

import java.util.ArrayList;
import java.util.List;

public class EnrolleeService {

    private final Dao<EnrolleeEntity> enrolleeDao;

    public EnrolleeService(Dao enrolleeDao) {
        this.enrolleeDao = enrolleeDao;
    }

    public int sizeEnrollees() {
        return  enrolleeDao.size();
    }

    public List<Enrollee> getAllEnrollees() {
        return enrolleeDao.getAll().stream()
                .map(Enrollee::new)
                .toList();
    }

    public Enrollee getEnrollee (int id) {
        return new Enrollee((EnrolleeEntity)enrolleeDao.get(id).orElse(new EnrolleeEntity()));
    }

    public void save(Enrollee enrollee) {
        enrollee.setId(enrolleeDao.size());
        EnrolleeEntity enrolleeEntity = new EnrolleeEntity(enrollee);
        enrolleeDao.save(enrolleeEntity);
    }
    public List<Enrollee> getEnrollees(List<EnrolleeEntity> enrolleeEntitys)
    {
        List<Enrollee> enrollees = new ArrayList<>();
        for (EnrolleeEntity enrolleeEntity: enrolleeEntitys) {
            enrollees.add(new Enrollee(enrolleeEntity));
        }
        return enrollees;
    }
}