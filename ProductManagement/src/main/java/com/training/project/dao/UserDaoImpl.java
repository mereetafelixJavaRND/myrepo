package com.training.project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.training.project.db.DBUtility;
import com.training.project.model.Product;
import com.training.project.model.User;

public class UserDaoImpl implements UserDao {
	
	DBUtility db = new DBUtility();
	PreparedStatement pst;
	ResultSet rs;
	
	//Authentication of user
	
	public User authenticate(String username, String password) throws SQLException {
		
		String sql = "select * from user where username=? and password=?";
		pst = db.createPST(sql);
		pst.setString(1, username);
		pst.setString(2, password);
		rs = db.query(pst);
		if (rs.next()) {
			
			User user = new User();
			user.setName(rs.getString("name"));
			user.setPhone(rs.getLong("phone"));
			user.setEmail(rs.getString("email"));
			user.setUserName(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			return user;
			
		} else {
			
			return null;
			
		}
			
	}
	
	//Registration of user
	
	public int register(User user) throws SQLException {
		
		String sql = "insert into user(name,phone,email,username,password)values(?,?,?,?,?)";
		pst = db.createPST(sql);
		pst.setString(1, user.getName());
		pst.setLong(2, user.getPhone());
		pst.setString(3, user.getEmail());
		pst.setString(4, user.getUserName());
		pst.setString(5, user.getPassword());
	    return db.update(pst);
		
	}
	
	//Addition of product details
	
	public int add(Product product) throws SQLException {
		
		String sql = "insert into product(productId,productName,price,vendor,quantity,username,warranty)values(?,?,?,?,?,?,?)";
		pst = db.createPST(sql);
		pst.setInt(1, product.getProductId());
		pst.setString(2, product.getProductName());
		pst.setInt(3, product.getPrice());
		pst.setString(4, product.getVendor());
		pst.setInt(5, product.getQuantity());
		pst.setString(6, product.getUserName());
		pst.setInt(7,product.getWarranty());
		return db.update(pst);
		
	}
	
	//Getting all the products added by a particular user
	
	public List<Product> getAllProduct(String username) throws SQLException {
		
		String sql = "select * from product where username=?";
		pst = db.createPST(sql);
		pst.setString(1, username);
		rs = db.query(pst);
		List<Product> productList = new ArrayList<Product>();
		while (rs.next()) {
			
			Product product = new Product();
			product.setProductId(rs.getInt("productId"));
			product.setProductName(rs.getString("productName"));
			product.setPrice(rs.getInt("price"));
			product.setVendor(rs.getString("vendor"));
			product.setQuantity(rs.getInt("quantity"));
			product.setWarranty(rs.getInt("warranty"));
			productList.add(product);
		  
	    }
		return productList;

    }
	
	//Finding product with productid for updation
	
	public Product findProduct(int id) throws SQLException {
		
		String sql = "select * from product where productId=?";
		pst = db.createPST(sql);
		pst.setInt(1, id);
		rs = db.query(pst);
		if (rs.next()) {
			
			Product product = new Product();
			product.setProductId(rs.getInt("productId"));
			product.setProductName(rs.getString("productName"));
			product.setPrice(rs.getInt("price"));
			product.setVendor(rs.getString("vendor"));
			product.setQuantity(rs.getInt("quantity"));
			product.setWarranty(rs.getInt("warranty"));
			return product;
			
		}
		return null;
	
	}
	
	//Updating a particular product of the user
	
	public int updateProduct(Product product1) throws SQLException {
		
		String sql = "update product set productName=?,price=?,vendor=?,quantity=?,username=?,warranty=? where productId=?";
		pst = db.createPST(sql);
		pst.setString(1, product1.getProductName());
		pst.setInt(2, product1.getPrice());
		pst.setString(3, product1.getVendor());
		pst.setInt(4, product1.getQuantity());
		pst.setString(5, product1.getUserName());
		pst.setInt(6, product1.getWarranty());
		pst.setInt(7, product1.getProductId());
		return db.update(pst);
		
	}
	
	//Deleting a particular product of user
	
	public int deleteProduct(int id) throws SQLException {
		
		String sql = "delete from product where productId=?";
		pst = db.createPST(sql);
		pst.setInt(1, id);
		return db.update(pst);
		
	}
}

