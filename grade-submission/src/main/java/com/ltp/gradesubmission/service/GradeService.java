package com.ltp.gradesubmission.service;


import com.ltp.gradesubmission.entity.Grade;


import java.util.List;


public interface GradeService {

  Grade getGrade(Long id);

  Grade saveGrade(Grade grade, Long studentId, Long courseId);

  void deleteGrade();

  Grade updateGrade();

}


