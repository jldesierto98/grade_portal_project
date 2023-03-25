package com.ltp.gradesubmission.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="birth_date", nullable = false)
    private LocalDate birthDate;
}
