package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.Grade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class GradeRepository {
    //database storage - mock up - stores Grade Objects to list.
    List<Grade> grades = new ArrayList<>();
    public Grade getGrade(int index){
        return grades.get(index);
    }

    public void addGrade(Grade grade){
        grades.add(grade);
    }

    public void updateGrade(int index, Grade grade){
        grades.set(index, grade);
    }

    public Integer getSize(){
        return grades.size();
    }

    public List<Grade> getGrades(){
        return grades;
    }
}
