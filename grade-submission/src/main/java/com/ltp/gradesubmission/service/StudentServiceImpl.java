package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.exceptions.StudentNotFoundException;
import com.ltp.gradesubmission.repository.CourseRepository;
import com.ltp.gradesubmission.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;


    @Override
    public Student getStudent(Long id) {

       if(studentRepository.findById(id).isEmpty()){
            throw new ServiceException("Not found!");
        }
        this.printGrades(studentRepository.findById(id).get());
        return  studentRepository.findById(id).get();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
         studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudents() {
        return (List<Student>)studentRepository.findAll();
    }

    @Override
    public void printGrades(Student student) {
        student.getGrade().forEach(x -> System.out.println(x.getScore()));
    }

    @Override
    public Course addStudentToCourse(Long studentId, Long courseId) {
        Student student = StudentServiceImpl.unWrap(studentRepository.findById(studentId), studentId);
        Course course = CourseServiceImpl.unWrap(courseRepository.findById(courseId), courseId);

        course.getStudents().add(student);
        return courseRepository.save(course);
    }

    @Override
    public List<Student> getStudentsEnrolledInCourse(Long studentId) {
        Course course = CourseServiceImpl.unWrap(courseRepository.findById(studentId), studentId);
        return course.getStudents();
    }

    @Override
    public List<Course> getEnrolledCoursesOfStudent(Long studentId) {
        Student student = StudentServiceImpl.unWrap(studentRepository.findById(studentId), studentId);
        return student.getCourses();
    }

    static Student unWrap(Optional<Student> student, Long id){
        if (student.isPresent()) {
            return student.get();
        } else {
            throw new StudentNotFoundException(id);
        }
    }
}
