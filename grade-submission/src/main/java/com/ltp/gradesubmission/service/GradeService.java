package com.ltp.gradesubmission.service;


import com.ltp.gradesubmission.entity.Grade;


import java.util.List;


public interface GradeService {

    public List<Grade> getGrades();

    public Integer getGradeIndex(String id);

    public Grade getGradeById(String id);

    public void submitGrade(Grade grade);
}


