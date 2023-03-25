package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    private final StudentRepository studentRepository;
    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).get();
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
        return null;
    }
}
