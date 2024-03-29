package com.ltp.gradesubmission;


import com.ltp.gradesubmission.exceptions.EntityNotFoundException;
import com.ltp.gradesubmission.exceptions.ErrorResponse;
import com.ltp.gradesubmission.exceptions.StudentNotEnrolledError;
import com.ltp.gradesubmission.exceptions.StudentNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
public class    ApplicationExceptionHandler {

    @ExceptionHandler(com.ltp.gradesubmission.exception.CourseNotFoundException.class)
    public ResponseEntity<Object> handleCourseNotFoundException(com.ltp.gradesubmission.exception.CourseNotFoundException ex){
        ErrorResponse errorResponse = new ErrorResponse(Arrays.asList(ex.getMessage()));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentNotEnrolledError.class)
    public ResponseEntity<Object> handleStudentNotEnrolledError(StudentNotEnrolledError ex){
        ErrorResponse errorResponse = new ErrorResponse(Arrays.asList(ex.getMessage()));
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(com.ltp.gradesubmission.exception.GradeNotFoundException.class)
    public ResponseEntity<Object> handleGradeNotFoundException(com.ltp.gradesubmission.exception.GradeNotFoundException ex){
        ErrorResponse errorResponse = new ErrorResponse(Arrays.asList(ex.getMessage()));
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException ex){
        ErrorResponse errorResponse = new ErrorResponse(Arrays.asList(ex.getMessage()));
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        ErrorResponse error = new ErrorResponse(Arrays.asList("Data Integrity Violation: we cannot process your request."));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(DataIntegrityViolationException ex) {
        ErrorResponse error = new ErrorResponse(Arrays.asList("Data Entity Not Found!"));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
