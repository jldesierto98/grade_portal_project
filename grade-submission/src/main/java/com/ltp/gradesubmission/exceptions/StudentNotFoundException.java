package com.ltp.gradesubmission.exceptions;

public class StudentNotFoundException extends  RuntimeException{

    public StudentNotFoundException(Long id){
        super("The studet with id ".concat(id.toString()).concat(" does not exist in the database."));
    }
}
