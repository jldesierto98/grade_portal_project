package com.ltp.gradesubmission.service;


import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.exception.GradeNotFoundException;
import com.ltp.gradesubmission.exceptions.StudentNotEnrolledError;
import com.ltp.gradesubmission.repository.CourseRepository;
import com.ltp.gradesubmission.repository.GradeRepository;
import com.ltp.gradesubmission.repository.StudentRepository;
import com.ltp.gradesubmission.request.SaveGradeRequest;
import com.ltp.gradesubmission.response.UpdateGradeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Override
    public Grade getGrade(Long studentId, Long courseId) {
       Optional<Grade> grade = Optional.ofNullable(gradeRepository.findByStudentIdAndCourseId(studentId, courseId));
       return unWrap(grade, studentId, courseId);
    }

    @Override
    public Grade saveGrade(SaveGradeRequest saveGradeRequest, Long studentId, Long courseId) {

        Student student = StudentServiceImpl.unWrap(studentRepository.findById(studentId), studentId);
        Course course = CourseServiceImpl.unWrap(courseRepository.findById(courseId), courseId);

        if(!student.getCourses().contains(course)){
            throw new StudentNotEnrolledError(studentId, courseId);
        }

        Grade grade = new Grade();
        grade.setStudent(student);
        grade.setCourse(course);
        return gradeRepository.save(grade);

    }

    @Override
    public void deleteGrade(Long studentId, Long courseId) {
        gradeRepository.deleteByStudentIdAndCourseId(studentId, courseId);
    }

    @Override
    public UpdateGradeResponse updateGrade(String score, Long studentId, Long courseId) {
        Grade grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        grade.setScore(score);
        gradeRepository.save(grade);

        //check if update is successful.
        boolean isUpdated = grade.getScore().equals(score);
        String message = isUpdated ? "Update Successful" : "Update Failed";

        //build UpdateGradeResponse
        UpdateGradeResponse updateGradeResponse = new UpdateGradeResponse();
        updateGradeResponse.setIsUpdated(isUpdated);
        updateGradeResponse.setMessage(message);

        return updateGradeResponse;
    }

    @Override
    public List<Grade> getStudentGrades(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    @Override
    public List<Grade> getCourseGrades(Long courseId) {
        return gradeRepository.findByCourseId(courseId);
    }

    static Grade unWrap(Optional<Grade> grade, Long studentId, Long courseId){
        if (grade.isPresent()) {
            return grade.get();
        } else {
            throw new GradeNotFoundException(studentId, courseId);
        }
    }

    @Override
    public List<Grade> getAllGrades() {
        return (List<Grade>) gradeRepository.findAll();
    }
}
