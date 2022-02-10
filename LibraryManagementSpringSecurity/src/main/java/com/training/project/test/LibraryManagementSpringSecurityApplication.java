package com.training.project.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.training.project.controller"})
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.training.project.model"})
@ComponentScan(basePackages = {"com.training.project.controller","com.training.project.service","com.training.project.security"})
@EnableJpaRepositories("com.training.project.dao")
public class LibraryManagementSpringSecurityApplication {

	public static void main(String[] args) {

		SpringApplication.run(LibraryManagementSpringSecurityApplication.class, args);

	}

}
