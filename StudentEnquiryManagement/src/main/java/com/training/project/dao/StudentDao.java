package com.training.project.dao;

import java.util.List;

import com.training.project.model.Students;

public interface StudentDao {

	public String save(Students student);

	public List<Students> authenticate(Students student);

	public Students getStudentById(int id);

	public List<Students> searchByName(String name);

}
