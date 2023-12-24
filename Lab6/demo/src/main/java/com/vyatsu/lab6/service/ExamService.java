package com.vyatsu.lab6.service;

import com.vyatsu.lab6.dao.Dao;
import com.vyatsu.lab6.entity.ExamEntity;
import com.vyatsu.lab6.models.Exam;

import java.util.ArrayList;
import java.util.List;

public class ExamService {

    private final Dao<ExamEntity> examDao;

    public ExamService(Dao<ExamEntity> examDao) {
        this.examDao = examDao;
    }

    public int sizeExams() {
        return  examDao.size();
    }

    public List<Exam> getAllExams() {
        return examDao.getAll().stream()
                .map(Exam::new)
                .toList();
    }

    public Exam getExam (int id) {
        return new Exam((ExamEntity)examDao.get(id).orElse(new ExamEntity()));
    }


    public void save(Exam exam) {
        ExamEntity examEntity = new ExamEntity(exam);
        examDao.save(examEntity);
    }
    public List<Exam> getExams(List<ExamEntity> examEntities)
    {
        List<Exam> exams = new ArrayList<>();
        examEntities.forEach(entity -> exams.add(new Exam(entity)));
        return exams;
    }
}