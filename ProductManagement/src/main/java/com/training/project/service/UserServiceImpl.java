package com.training.project.service;

import java.sql.SQLException;
import java.util.List;
import com.training.project.dao.UserDao;
import com.training.project.dao.UserDaoImpl;
import com.training.project.model.Product;
import com.training.project.model.User;

public class UserServiceImpl implements UserService {
	
	UserDao userDao = new UserDaoImpl();
	
	//Authentication of user
	
	public User authenticate(String username,String password) throws SQLException {
		
			User user = userDao.authenticate(username, password);
			if(user!=null){
				
				return user;
				
			}
			return null;
			
	}
	
	//Registration
	
	public int register(User user) throws SQLException{
		
		return userDao.register(user);
		
	}
	
	//Adding Product
	
	public int addProduct(Product product) throws SQLException {
		
		return userDao.add(product);
		
	}
	
	//Get all product of particular user
	
	public List<Product> getAllProduct(String username) throws SQLException {
		
		return userDao.getAllProduct(username);
		
	}
	
	//selecting a particular product of user
	
	public Product findProduct(int id) throws SQLException {
		
		return userDao.findProduct(id);
		
	}
	
	//Update a particular product of user
	
	public int updateProduct(Product product1) throws SQLException {
		
		 return userDao.updateProduct(product1);
		
	}
	
	//Deleting a particular product
	
	public int deleteProduct(int id) throws SQLException {
		
		return userDao.deleteProduct(id);
		
	}
	
}
