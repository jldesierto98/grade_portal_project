package com.ltp.gradesubmission.controller;



import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.service.GradeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class GradeController {

    private final GradeService gradeService;

    @GetMapping("/grades")
    public String getGrades(Model model){
        model.addAttribute("grades", gradeService.getGrades());
        return "grades";
    }


    @GetMapping("/")
    public String gradeForm(Model model, @RequestParam(required = false) String id){
        model.addAttribute("grade", gradeService.getGradeById(id));
        return "/form";
    }


    @PostMapping("/submit")
    public String submitForm(@Valid Grade grade, BindingResult result){
        if(result.hasErrors()){ return "/form"; }
        gradeService.submitGrade(grade);
        return "redirect:/grades";
    }
}
