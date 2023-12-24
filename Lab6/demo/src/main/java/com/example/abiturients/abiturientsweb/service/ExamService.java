package com.example.abiturients.abiturientsweb.service;

import com.example.abiturients.abiturientsweb.dao.Dao;
import com.example.abiturients.abiturientsweb.entity.EnrolleeEntity;
import com.example.abiturients.abiturientsweb.entity.ExamEntity;
import com.example.abiturients.abiturientsweb.models.Enrollee;
import com.example.abiturients.abiturientsweb.models.Exam;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ExamService {
    private Dao examDao;

    public ExamService(Dao examDao) {
        this.examDao = examDao;
    }

    public long sizeExams() {
        return examDao.size();
    }

    public List<Exam> getAllExams() {
        return examDao.getAll().stream().map(x -> new Exam((ExamEntity) x)).toList();
    }

    public List<Exam> getExamsByEnrolleeId(int idEnrollee) {
        List<Exam> examList;
        examList = getAllExams().stream().filter(x -> x.getIdEnrollee() == idEnrollee).toList();
        return examList;
    }

    public void save(Exam exam) {
        exam.setIdEnrollee(exam.getIdEnrollee());
        ExamEntity examEntity = new ExamEntity(exam);
        examDao.save(examEntity);
    }

}
