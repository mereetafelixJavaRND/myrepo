package com.training.project.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.project.dao.UserDao;
import com.training.project.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	@Transactional
	public void save(User user) {

		userDao.save(user);

	}

	@Override
	@Transactional
	public Optional<User> getUserById(int id) {

		return userDao.findById(id);

	}

	@Override
	public List<User> getAllUsers() {

		return null;

	}

	@Override
	public void deleteUser(int id) {

		userDao.deleteById(id);

	}

}
