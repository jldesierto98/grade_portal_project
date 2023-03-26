package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;
    @Override
    public Student getStudent(Long id) {

       if(studentRepository.findById(id).isEmpty()){
            throw new ServiceException("Not found!");
        }

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
}
