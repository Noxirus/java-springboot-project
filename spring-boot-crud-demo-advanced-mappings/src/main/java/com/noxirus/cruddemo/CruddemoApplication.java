package com.noxirus.cruddemo;

import com.noxirus.cruddemo.dao.AppDAO;
import com.noxirus.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int theId = 1;
		appDAO.deleteStudentById(theId);
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		int theId = 2;

		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);
		Course tempCourse1 = new Course("How to play chess");
		Course tempCourse2 = new Course("Parenting 101");
		Course tempCourse3 = new Course("Sleep fundamentals");

		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);
		tempStudent.addCourse(tempCourse3);

		appDAO.update(tempStudent);
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int theId = 2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		System.out.println(tempStudent);
		System.out.println(tempStudent.getCourses());
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int theId = 10;

		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);

		System.out.println(tempCourse);
		System.out.println(tempCourse.getStudents());
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		Course tempCourse = new Course("Pacman - how to score one million points");

		Student tempStudent1 = new Student("Flip", "Phil", "FilFlip@gmail.com");
		Student tempStudent2 = new Student("Flop", "Phinneas", "Floppinneas@gmail.com");

		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		appDAO.save(tempCourse);
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Deleting course id: " + theId);

		appDAO.deleteCourseById(theId);
	}

	private void retrieveCourseAndReview(AppDAO appDAO) {
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewByCourseId(theId);

		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course tempCourse = new Course("Pacman - How To Score One Million Points");

		tempCourse.addReview(new Review("Great Course! Lots of work"));
		tempCourse.addReview(new Review("Terrible! Lots of work"));
		tempCourse.addReview(new Review("It was ok! Lots of work"));
		tempCourse.addReview(new Review("Long! Lots of work"));

		appDAO.save(tempCourse);
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Deleting course id: " + theId);

		appDAO.deleteCourseById(theId);
	}

	private void updateCourse(AppDAO appDAO) {

		int theId = 10;

		System.out.println("Finding course id: " + theId);
		Course tempCourse = appDAO.findCourseById(theId);

		tempCourse.setTitle("This is a new Course!");
		appDAO.update(tempCourse);
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		tempInstructor.setLastName("TESTING");
		appDAO.update(tempInstructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;

		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("Found Instructor: " + tempInstructor);
		System.out.println("The Courses: " + tempInstructor.getCourses());
		System.out.println("You're done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);

		System.out.println("Finding Courses for instructor id: " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		tempInstructor.setCourses(courses);

		System.out.println("The associated courses: " + tempInstructor.getCourses());
		System.out.println("Done");

	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("The associated courses: "+  tempInstructor.getCourses());
		System.out.println("Done");
	}


	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Yoshi", "Ken", "Yoken@gmail.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("www.pupper.com/youtube", "eating cheese");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1 = new Course("Air guitar - Ultimate Guide");
		Course tempCourse2 = new Course("Pinball Master Class - Ultimate Guide");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		appDAO.save(tempInstructor);
		System.out.println("Done");
	}

	private void deleteInstructorDetail(AppDAO appDAO){
		int theId = 3;
		appDAO.deleteInstructorDetailById(theId);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		System.out.println(tempInstructorDetail);

		System.out.println(tempInstructorDetail.getInstructor());
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Yoshi", "Ken", "Yoken@gmail.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("www.pupper.com/youtube", "eating cheese");

		tempInstructor.setInstructorDetail(tempInstructorDetail);
		System.out.println("Saving: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done");
	}

	private void findInstructor(AppDAO appDAO){
		Instructor foundInstructor = appDAO.findInstructorById(1);

		System.out.println("Instructor: " + foundInstructor.toString());

		System.out.println("Details: " + foundInstructor.getInstructorDetail().toString());
	}

	private void deleteInstructor(AppDAO appDAO){
		appDAO.deleteInstructorById(1);
	}
}
