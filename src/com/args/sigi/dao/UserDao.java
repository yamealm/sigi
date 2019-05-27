package com.args.sigi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.args.sigi.exception.UserNotFoundException;
import com.args.sigi.generic.dao.GenericDao;
import com.args.sigi.object.User;

public class UserDao extends GenericDao {
	
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	 static final String DB_URL = "jdbc:mysql://localhost/sigi";
	 
	 //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "1nt3r4xt3l3ph0nyDB";//cambia tu clave gordo 
	 
	 
	public static User getUserByLoginPassword(String login, String password)
			throws SQLException, Exception, UserNotFoundException {
		Connection conn = null;
		Statement stmt = null;
		User user = new User();
		Boolean hasResult = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM user WHERE login='" + login
					+ "' AND password='" + password + "' LIMIT 1;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				hasResult = true;
				user.setId(rs.getLong("id"));
				user.setName(rs.getString("name"));
				user.setLastName(rs.getString("lastName"));
				user.setLogin(rs.getString("login"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setIsactive(rs.getBoolean("isActive"));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
			throw new SQLException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		if (!hasResult) {
			throw new UserNotFoundException("User not found");
		}
		return user;
	}
	

	public static List<User> listUser()throws SQLException, Exception, UserNotFoundException {
		Connection conn = null;
		Statement stmt = null;
		List <User> users = new ArrayList<User>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM user;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getLong("id"));
				user.setName(rs.getString("name"));
				user.setLastName(rs.getString("lastName"));
				user.setLogin(rs.getString("login"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setIsactive(rs.getBoolean("isActive"));
				users.add(user);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
			throw new SQLException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		if (users.isEmpty()) {
			throw new UserNotFoundException("User not found");
		}
		return users;
	}
	
}
