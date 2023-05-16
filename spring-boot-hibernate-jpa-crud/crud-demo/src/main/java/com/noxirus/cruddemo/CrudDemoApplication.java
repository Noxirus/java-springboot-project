package com.noxirus.cruddemo;

import com.noxirus.cruddemo.dao.StudentDAO;
import com.noxirus.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			readStudent(studentDAO, 1);
		};
	}

	private void readStudent(StudentDAO studentDAO, Integer id){
		Student tempStudent = studentDAO.findById(id);
		System.out.println("Found student: " + tempStudent.toString());
	}

	private void createStudent(StudentDAO studentDAO, Student newStudent) {
		studentDAO.save(newStudent);
		System.out.println("Saved student. Generated id: " + newStudent.getId());
	}
}
