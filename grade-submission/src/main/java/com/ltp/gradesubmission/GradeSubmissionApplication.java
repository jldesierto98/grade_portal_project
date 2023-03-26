package com.ltp.gradesubmission;

import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class GradeSubmissionApplication implements CommandLineRunner{

	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(GradeSubmissionApplication.class, args);
	}

	//For auto input of data in h2 upon running. For testing purposes only.
	@Override
	public void run(String... args) throws Exception {
		Student[] students = new Student[] {
				new Student(1L, "Harry Potter", LocalDate.parse(("1980-07-31"))),
				new Student(2L, "Ron Weasley", LocalDate.parse(("1980-03-01"))),
				new Student(3L, "Hermione Granger", LocalDate.parse(("1979-09-19"))),
				new Student(4L, "Neville Longbottom", LocalDate.parse(("1980-07-30")))
		};

		Arrays.asList(students).forEach(student -> studentRepository.save(student));
	}


}
