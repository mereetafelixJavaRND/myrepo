package com.training.project.service;

import java.util.List;

import com.training.project.model.Students;

public interface StudentService {

	public String save(Students student);

	public List<Students> authenticate(Students student);

	public Students getStudentById(int id);

	public List<Students> searchByName(String name);
}
