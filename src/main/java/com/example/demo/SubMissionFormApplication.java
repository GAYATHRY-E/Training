/**
 * Spring Boot SubMission form for students.
 * class name: SubMissionFormApplication
 * description :Application class for SubMission form.
 * @author GAYATHRY E
 * @version jdk 8
 *
 */

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class SubMissionFormApplication extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SubMissionFormApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SubMissionFormApplication.class, args);
	}

}
