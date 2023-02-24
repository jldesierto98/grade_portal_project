package com.ltp.gradesubmission.entity;

import com.ltp.gradesubmission.validations.Score;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
@ToString
public class Grade {

    @NotBlank(message = "Name cannot be left blank or empty!")
    private String name;

    @NotBlank(message = "Do not leave the subject empty!")
    private String subject;

    @Score(message = "Please Enter Valid Score Value")
    private String score;
    private String id;

    public Grade(String name, String subject, String score){
        this.name = name;
        this.subject = subject;
        this.score = score;
        this.id = UUID.randomUUID().toString();
    }

    public Grade(){
        this.id = UUID.randomUUID().toString();
    }

}
