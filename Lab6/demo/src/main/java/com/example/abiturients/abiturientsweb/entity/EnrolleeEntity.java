package com.example.abiturients.abiturientsweb.entity;

import com.example.abiturients.abiturientsweb.models.Enrollee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ENROLLEE")
public class EnrolleeEntity {

    @Id
    @GeneratedValue
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "FULLNAME", length = 64, nullable = false)
    private String fullName;

    //@Temporal(TemporalType.DATE)
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "BIRTHDAY", nullable = false)
    private Date birthday;

    public EnrolleeEntity(Enrollee enrollee) {
        setId(enrollee.getId());
        setBirthday(enrollee.getBirthday());
        setFullName(enrollee.getFullName());
    }

    private Date transformDate(java.util.Date date) {
        return new java.sql.Date(date.getYear(), date.getMonth(), date.getDay());
    }
}

