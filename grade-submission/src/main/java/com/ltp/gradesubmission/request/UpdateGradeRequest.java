package com.ltp.gradesubmission.request;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Student;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "Update Grade Request")
public class UpdateGradeRequest {

    @ApiModelProperty(value = "Score")
    private String score;

    @ApiModelProperty(value = "Student Name")
    private Student student;

    @ApiModelProperty(value = "Course")
    private Course course;
}
