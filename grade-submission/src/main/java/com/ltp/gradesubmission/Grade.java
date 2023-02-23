package com.ltp.gradesubmission;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Grade {

    @NotBlank(message = "Name cannot be left blank or empty!")
    private String name;

    @NotBlank(message = "Do not leave the subject empty!")
    private String subject;

    @Score(message = "Please Enter Valid Score Value")
    private String score;
    private String id;

    public Grade(){
        this.id = UUID.randomUUID().toString();
    }
}
