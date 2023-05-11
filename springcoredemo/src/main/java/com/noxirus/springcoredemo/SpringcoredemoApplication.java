package com.noxirus.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		//Explicitly tell the application which packages to scan for components (this particular example is not required)
		scanBasePackages = {"com.noxirus.springcoredemo"}
)
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
