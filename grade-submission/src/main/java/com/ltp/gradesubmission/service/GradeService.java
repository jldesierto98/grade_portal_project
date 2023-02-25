package com.ltp.gradesubmission.service;


import com.ltp.gradesubmission.Constants;
import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.repository.GradeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;
@Service
@AllArgsConstructor
public class GradeService {

    private final GradeRepository gradeRepository;

    public Grade getGrade(int index){
        return gradeRepository.getGrade(index);
    }

    public void addGrade(Grade grade){
        gradeRepository.addGrade(grade);
    }

    public void updateGrade(int index, Grade grade){
        gradeRepository.updateGrade(index, grade);
    }

    public Integer getSize(){
        return gradeRepository.getSize();
    }

    public List<Grade> getGrades(){
        return gradeRepository.getGrades();
    }

    public Integer getGradeIndex(String id){

        //gets the index of grade based on id. scans the getGrades list (mock database)
       return IntStream.range(0, getGrades().size())
               .filter(i -> getGrade(i).getId().equals(id))
               .findFirst()
               .orElse(Constants.INDEX_NOT_FOUND);
    }

    public Grade getGradeById(String id){
        int index = getGradeIndex(id);
        return index == Constants.INDEX_NOT_FOUND ? new Grade() : getGrade(index);
    }

    public void submitGrade(Grade grade){

        int index = getGradeIndex(grade.getId());

        if(index == Constants.INDEX_NOT_FOUND){
            this.addGrade(grade);
        }else{
            this.updateGrade(index, grade);
        }
    }
}


