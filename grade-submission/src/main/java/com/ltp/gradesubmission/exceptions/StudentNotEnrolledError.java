package com.ltp.gradesubmission.exceptions;

public class StudentNotEnrolledError extends RuntimeException{

    public StudentNotEnrolledError(Long studentId, Long courseId){
        super("The student with id " + studentId + " is not enrolled in course " + courseId );
    }
}
