package com.ltp.gradesubmission.controller;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@Controller
@RequestMapping(path = "/student")
public class StudentController {


    private final StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        return new ResponseEntity<>(studentService.getStudent(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudent(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @PutMapping("/{studentId}/course/{courseId}")
    public ResponseEntity<Course> enrollStudent(@PathVariable Long studentId, @PathVariable Long courseId){
        return new ResponseEntity<>(studentService.addStudentToCourse(studentId, courseId), HttpStatus.ACCEPTED);
    }

    @GetMapping("/course/{courseId}/enrolledCourses")
    public ResponseEntity<List<Student>> getEnrolledStudents(@PathVariable Long courseId){
        return new ResponseEntity<>(studentService.getStudentsEnrolledInCourse(courseId), HttpStatus.OK);
    }

    @GetMapping("/{studentId}/enrolledCourses")
    public ResponseEntity<List<Course>> getEnrolledCourses(@PathVariable Long studentId){
        return new ResponseEntity<>(studentService.getEnrolledCoursesOfStudent(studentId), HttpStatus.OK);
    }
}
