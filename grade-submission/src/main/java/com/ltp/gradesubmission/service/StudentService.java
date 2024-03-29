package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Student;

import java.util.List;

public interface StudentService {
    Student getStudent(Long id);
    Student saveStudent(Student student);
    void deleteStudent(Long id);
    List<Student> getStudents();
    void printGrades(Student student);
    Course addStudentToCourse(Long studentId, Long courseId);
    List<Student> getStudentsEnrolledInCourse(Long courseId);
    List<Course> getEnrolledCoursesOfStudent(Long studentId);
}
