package com.vyatsu.lab6.models;

import com.vyatsu.lab6.entity.ExamEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Exam {
    public Exam(ExamEntity exam)
    {
        this.subject = exam.getSubject();
        this.score = exam.getScore();
        this.enrolleeId = exam.getEnrolleeId();
    }

    String subject;
    int score;
    int enrolleeId;
}
