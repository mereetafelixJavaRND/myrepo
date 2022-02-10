package com.training.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.project.dao.UserDao;
import com.training.project.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	@Transactional
	public void saveOrUpdate(User user) {
		System.out.println("service");
		userDao.saveOrUpdate(user);
	}

	@Override
	@Transactional
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}

	@Override
	@Transactional
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUsers();
	}

	@Override
	@Transactional
	public void deleteUser(int id) {
		userDao.deleteUser(id);

	}

}
