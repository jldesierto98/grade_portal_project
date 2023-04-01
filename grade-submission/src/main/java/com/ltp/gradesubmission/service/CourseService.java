package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.entity.Course;

import java.util.List;

public interface CourseService {

    Course getCourses(Long id);
    Course saveCourse(Course course);
    void deleteCourse(Long id);
    List<Course> getCourses();

}
