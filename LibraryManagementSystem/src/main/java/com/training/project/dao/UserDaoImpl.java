package com.training.project.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.training.project.model.User;

@Repository
@EnableTransactionManagement
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void saveOrUpdate(User user) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);

	}

	@Override
	@Transactional
	public User getUserById(int id) {

		Session session = sessionFactory.openSession();
		User user =session.get(User.class, id);
		return user;

	}

	@Override
	@Transactional
	public List<User> getAllUsers() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.addOrder(Order.asc("name"));
		List<User> user = criteria.list();
		return user;

	}

	@Override
	@Transactional
	public void deleteUser(int id) {

		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		session.delete(user);

	}

}
