package com.ltp.gradesubmission.entity;

import com.ltp.gradesubmission.validations.Score;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@Entity
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

//    @Column(name = "name")
//    @NotBlank(message = "Name cannot be left blank or empty!")
//    private String name;

//    @Column(name = "subject")
//    @NotBlank(message = "Do not leave the subject empty!")
//    private String subject;

    @Column(name = "score")
    @Score(message = "Please Enter Valid Score Value")
    private String score;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;
}
