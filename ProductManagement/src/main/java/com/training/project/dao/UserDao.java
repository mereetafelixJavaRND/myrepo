package com.training.project.dao;

import java.sql.SQLException;
import java.util.List;
import com.training.project.model.Product;
import com.training.project.model.User;

public interface UserDao {
	
	public User authenticate(String loginName, String password) throws SQLException;

	public int register(User user) throws SQLException;

	public int add(Product product) throws SQLException;

	public List<Product> getAllProduct(String username) throws SQLException;

	public Product findProduct(int id) throws SQLException;

	public int updateProduct(Product product1) throws SQLException;

	public int deleteProduct(int id) throws SQLException;
	
}
