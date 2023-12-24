package com.vyatsu.lab6.models;

import com.vyatsu.lab6.entity.EnrolleeEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Enrollee {

    public Enrollee(EnrolleeEntity enrollee) {
        this.id = enrollee.getId();
        this.fullName = enrollee.getFullName();
        this.birthday = enrollee.getBirthday();
    }

    @NonNull int id;

    @NonNull String fullName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date birthday;
}
