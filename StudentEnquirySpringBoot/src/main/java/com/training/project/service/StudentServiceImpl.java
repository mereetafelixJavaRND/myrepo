package com.training.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.project.dao.StudentDao;
import com.training.project.model.Students;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao sdao;

	@Override
	@Transactional

	public Students save(Students student) {

		return sdao.save(student);

	}

	@Override
	@Transactional
	public Iterable<Students> findAll() {

		return sdao.findAll();

	}

	@Override
	@Transactional
	public Optional<Students> getStudentById(int id) {

		return sdao.findById(id);

	}

}
