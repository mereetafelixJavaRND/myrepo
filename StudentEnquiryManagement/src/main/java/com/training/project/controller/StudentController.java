package com.training.project.controller;

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

	@PostMapping("/login")
	public String authenticateStudent(@RequestBody Students student){

		List<Students> studentList = service.authenticate(student);
		if(studentList.isEmpty()) {

			throw new StudentNotFound("Invalid Student");

		}else {

			return "Student Signed-in Successfully!.";

		}
	}

	@PostMapping("/student")
	public String saveStudent(@RequestBody Students student){

		student.setId(0);
		return service.save(student);

	}

	@GetMapping("/student/{name}")
	public List<Students> searchByName(@PathVariable String name) {

		List<Students> student = service.searchByName(name);
		return student;

	}

}
