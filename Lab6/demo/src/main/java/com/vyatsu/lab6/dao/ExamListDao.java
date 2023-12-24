package com.vyatsu.lab6.dao;

import com.vyatsu.lab6.entity.ExamEntity;
import com.vyatsu.lab6.models.Exam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamListDao implements Dao<ExamEntity> {
    List<ExamEntity> exams = new ArrayList<>();

    public ExamListDao(ExamDBDao examDBDao) {
        exams = examDBDao.getAll();
    }

    @Override
    public int size(){
        return exams.size();
    }

    @Override
    public Optional<ExamEntity> get(int id) {
        return Optional.of(exams.get(id));

    }

    @Override
    public List<ExamEntity> getAll() {
        return exams;
    }

    @Override
    public void save(ExamEntity exam) {
        exams.add(exam);
    }

    @Override
    public void delete(ExamEntity exam) {
        exams.remove(exam);
    }
    public List<ExamEntity> getExamsByEnrolleeId(int idEnrollee) {
        return exams.stream().filter(exam -> exam.getEnrolleeId() == idEnrollee).toList();

    }
}
