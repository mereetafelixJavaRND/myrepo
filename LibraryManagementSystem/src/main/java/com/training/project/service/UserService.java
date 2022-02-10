package com.training.project.service;

import java.util.List;

import com.training.project.model.User;

public interface UserService {

	void saveOrUpdate( User user);

	User getUserById(int id);

	List<User> getAllUsers();

	void deleteUser(int id);



}
