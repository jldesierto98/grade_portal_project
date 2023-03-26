package com.ltp.gradesubmission.service;
import com.ltp.gradesubmission.entity.Grade;


public interface GradeService {

  Grade getGrade(Long studentId, Long courseId);

  Grade saveGrade(Grade grade, Long studentId, Long courseId);

  void deleteGrade();

  Grade updateGrade();
}


