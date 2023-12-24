package com.vyatsu.lab6.entity;
import com.vyatsu.lab6.models.Enrollee;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "ENROLLEE")
public class EnrolleeEntity {

    public EnrolleeEntity(Enrollee enrollee)
    {
        this.id = enrollee.getId();
        this.fullName = enrollee.getFullName();
        this.birthday = enrollee.getBirthday();
    }

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "FULLNAME", length = 64, nullable = false)
    private String fullName;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTHDAY", nullable = false)
    private Date birthday;

}
