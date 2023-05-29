package com.ltp.gradesubmission.service;
import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.request.SaveGradeRequest;
import com.ltp.gradesubmission.response.UpdateGradeResponse;

import java.util.List;


public interface GradeService {

  Grade getGrade(Long studentId, Long courseId);

  Grade saveGrade(SaveGradeRequest saveGradeRequest, Long studentId, Long courseId);

  void deleteGrade(Long studentId, Long courseId);

  UpdateGradeResponse updateGrade(String score, Long studentId, Long courseId);

  List<Grade> getStudentGrades(Long studentId);

  List<Grade> getCourseGrades(Long courseId);

  List<Grade> getAllGrades();
}


