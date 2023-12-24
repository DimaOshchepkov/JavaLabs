package com.vyatsu.lab6.entity;

import com.vyatsu.lab6.models.Enrollee;
import com.vyatsu.lab6.models.Exam;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "EXAM")
public class ExamEntity  {
    public ExamEntity(Exam exam)
    {
        this.subject = exam.getSubject();
        this.score = exam.getScore();
        this.enrolleeId = exam.getEnrolleeId();
    }

    @Id
    @GeneratedValue
    @Column(name = "SUBJECT", length = 64, nullable = false)
    private String subject;

    @Column(name = "SCORE", nullable = false)
    private int score;

    @Column(name = "ENROLLEEID", nullable = false)
    private int enrolleeId;
}
