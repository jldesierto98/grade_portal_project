package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.Constants;
import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.repository.GradeRepository;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;


@AllArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    GradeRepository gradeRepository;

    @Override
    public Grade getGrade(Long studentId, Long courseId) {
        return Optional.of(gradeRepository.findByStudentId(studentId))
                .orElseThrow(() -> new ServiceException("Student not found!"));
    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        return gradeRepository.save(grade);
    }

    @Override
    public void deleteGrade() {

    }

    @Override
    public Grade updateGrade() {
        return null;
    }

}
