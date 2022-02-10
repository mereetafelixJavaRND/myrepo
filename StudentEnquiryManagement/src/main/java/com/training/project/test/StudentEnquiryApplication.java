package com.training.project.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication(scanBasePackages = {"com.training.project", "com.training.project.controller"})
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.training.project.model"})

public class StudentEnquiryApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentEnquiryApplication.class, args);
	}

}
