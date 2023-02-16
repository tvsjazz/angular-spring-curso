package com.loiane.crudjava;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.loiane.crudjava.model.Course;
import com.loiane.crudjava.repository.CourseRepository;

@SpringBootApplication
public class CrudJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudJavaApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();

			Course c = new Course();
			c.setName("Angular com Spring");
			c.setCategory("front-end");

			courseRepository.save(c);
		};
	}

}
