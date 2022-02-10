package com.training.project.service;

import java.util.List;
import java.util.Optional;

import com.training.project.model.User;

public interface UserService {

	void save( User user);

	Optional<User> getUserById(int id);

	List<User> getAllUsers();

	void deleteUser(int id);

}
