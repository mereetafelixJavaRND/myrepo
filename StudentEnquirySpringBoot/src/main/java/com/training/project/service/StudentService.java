package com.training.project.service;

import java.util.List;
import java.util.Optional;

import com.training.project.model.Students;

public interface StudentService {

	public Students save(Students student);

	public Iterable<Students> findAll();

	public Optional<Students> getStudentById(int id);

	
}
