package com.training.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.project.exception.StudentNotFound;
import com.training.project.model.Students;
import com.training.project.service.StudentService;

@RestController
@RequestMapping("/api/v1/ems")
public class StudentController {

	@Autowired
	StudentService service;

	Boolean authenticate = false;
	Boolean register = false;

	@GetMapping("/login")
	public String authenticateStudent(@RequestBody Students student){

		Iterable<Students> studentList = service.findAll();
		String userName = student.getUsername();
		String password = student.getPassword();
		studentList.forEach(s->{

			if(s.getUsername().equals(userName) && s.getPassword().equals(password)) {

				authenticate=true;

			}

		});

		if(authenticate == false) {

			throw new StudentNotFound("Invalid Student");

		}else {

			return "Student Signed-in Successfully!.";

		}

	}

	@PostMapping("/student")
	public String saveStudent(@RequestBody Students student){

		Iterable<Students> studentList = service.findAll();
		studentList.forEach(s -> {

			if(student.getUsername().equals(s.getUsername()) &&
					student.getPassword().equals(s.getPassword())){

				register = true;

			}

		});

		if(register == false) {

			student.setId(0);
			service.save(student);
			return "Student registered successfully";


		} else {

			return "Username and password already exist";
		}

	}

	@GetMapping("/student/{name}")
	public List<Students> searchByName(@PathVariable String name) {

		Iterable<Students> studentItr = service.findAll();
		List<Students>student = new ArrayList<Students>();
		studentItr.forEach(s -> {

			if(s.getName().equals(name)) {

				student.add(s);

			}

		});

		return student;

	}

}
