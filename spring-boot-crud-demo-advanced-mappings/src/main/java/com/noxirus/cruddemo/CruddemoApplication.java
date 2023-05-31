package com.noxirus.cruddemo;

import com.noxirus.cruddemo.dao.AppDAO;
import com.noxirus.cruddemo.entity.Course;
import com.noxirus.cruddemo.entity.Instructor;
import com.noxirus.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			createInstructorWithCourses(appDAO);
		};
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
