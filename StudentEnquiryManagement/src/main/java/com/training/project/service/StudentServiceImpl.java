package com.training.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.project.dao.StudentDao;
import com.training.project.model.Students;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao pdao;

	@Override
	@Transactional

	public String save(Students student) {

		return pdao.save(student);

	}

	@Override
	@Transactional
	public List<Students> authenticate(Students student) {

		return pdao.authenticate(student);

	}

	@Override
	@Transactional
	public Students getStudentById(int id) {

		return pdao.getStudentById(id);
	}

	@Override
	@Transactional
	public List<Students> searchByName(String name) {

		return pdao.searchByName(name);

	}







}
