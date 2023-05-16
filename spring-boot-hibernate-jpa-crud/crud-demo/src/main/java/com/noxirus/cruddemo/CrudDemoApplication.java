package com.noxirus.cruddemo;

import com.noxirus.cruddemo.dao.StudentDAO;
import com.noxirus.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			createStudent(studentDAO, new Student("Prestor", "Pince", "PPince@yahoo.com"));
			createStudent(studentDAO, new Student("May", "Bud", "Mud@yahoo.com"));
			createStudent(studentDAO, new Student("Incide", "Syrall", "Incall@yahoo.com"));
		};
	}

	private void deleteStudent(StudentDAO studentDAO, Integer id){
		studentDAO.delete(id);
	}

	private void updateStudent(StudentDAO studentDAO){
		int studentId = 1;
		Student studentToUpdate = studentDAO.findById(studentId);
		studentToUpdate.setFirstName("Scooby");

		studentDAO.update(studentToUpdate);
		System.out.println("Updated student: " + studentToUpdate.toString());
	}

	private void getStudentsByLastName(StudentDAO studentDAO, String lastName){
		for(var student : studentDAO.findByLastName(lastName)){
			System.out.println("Found: " + student.toString());
		}
	}

	private void getAllStudents(StudentDAO studentDAO){
		List<Student> students = studentDAO.findAll();

		for(var student : students){
			System.out.println("Student: " + student.toString());
		}
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
