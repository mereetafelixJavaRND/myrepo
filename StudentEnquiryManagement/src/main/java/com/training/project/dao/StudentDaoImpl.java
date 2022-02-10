package com.training.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.training.project.model.Students;

@Repository
@EnableTransactionManagement
public class StudentDaoImpl implements StudentDao{


	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public String save(Students student) {

		Session session = entityManager.unwrap(Session.class);
		String username = student.getUsername();
		String password = student.getPassword();
		Query query = session.createQuery("from Students where username=:username and password=:password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		List<Students> studentList = query.getResultList();
		if(studentList.isEmpty()) {

			session.saveOrUpdate(student);
			return "Student Registered successfully";

		}else {

			return "Username and password already exist";

		}

	}

	@Override
	@Transactional
	public List<Students> authenticate(Students student) {

		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from Students where username=:username and password=:password");
		query.setParameter("username", student.getUsername());
		query.setParameter("password", student.getPassword());
		return query.getResultList();

	}

	@Override
	@Transactional
	public Students getStudentById(int id) {

		Session session = entityManager.unwrap(Session.class);
		Students student =session.get(Students.class, id);
		return student;

	}

	@Override
	@Transactional
	public List<Students> searchByName(String name) {

		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from Students where name=:name");
		query.setParameter("name", name);
		return query.getResultList();

	}

}
