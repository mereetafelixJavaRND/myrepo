package com.training.project.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtility {
	
	private static Connection con;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		try {
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=root");

		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}

	public PreparedStatement createPST(String sql) throws SQLException {
		
		PreparedStatement pst = con.prepareStatement(sql);
		return pst;
		
	}
	
	public int update(PreparedStatement pst) throws SQLException {
		
		return pst.executeUpdate();
		
	}
	
	public ResultSet query(PreparedStatement pst ) throws SQLException {
		
		return pst.executeQuery();
		
	}

	public boolean testCon() {
		
		if (con != null) {
			
			return true;

		} else
			
			return false;
	}

}
