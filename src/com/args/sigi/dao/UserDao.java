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
import com.args.sigi.object.Permission;
import com.args.sigi.object.PermissionGroup;
import com.args.sigi.object.Profile;
import com.args.sigi.object.User;

public class UserDao extends GenericDao {
	 
	public static User getUserByLoginPassword(String login, String password)
			throws SQLException, Exception, UserNotFoundException {
		Connection conn = null;
		Statement stmt = null;
		User user = new User();
		Boolean hasResult = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(JDBC_DB_URL, USER, PASS);
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
			conn = DriverManager.getConnection(JDBC_DB_URL, USER, PASS);
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

	public static Profile getCurrentProfile(Long userId)
			throws SQLException, Exception, UserNotFoundException {
		Connection conn = null;
		Statement stmt = null;
		
		Profile profile = new Profile();
		Boolean hasResult = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(JDBC_DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM sigi.profile WHERE id = (SELECT uhs.profileId FROM sigi.user_has_profile uhs WHERE uhs.userId="+ userId +")";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				hasResult = true;
				profile.setId(rs.getLong("id"));
				profile.setName(rs.getString("name"));
				profile.setEnabled(rs.getBoolean("enabled"));
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
		return profile;
	}
	
	
	public static List<Permission> getPermissionByProfileId(Long profileId)
			throws SQLException, Exception, UserNotFoundException {
		Connection conn = null;
		Statement stmt = null;
		List<Permission> permissions = new ArrayList<Permission>();
		
		Boolean hasResult = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(JDBC_DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM sigi.permission WHERE id = (SELECT php.permissionId FROM sigi.permission_has_profile php WHERE php.profileId="+ profileId +")";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				hasResult = true;
				Permission permission = new Permission();
				permission.setId(rs.getLong("id"));
				permission.setName(rs.getString("name"));
				permission.setEntity(rs.getString("entity"));
				permission.setAction(rs.getString("action"));
				permission.setPermissionGroupId(rs.getString("permissionGroupId"));
				permission.setEnabled(rs.getBoolean("enabled"));
				permissions.add(permission);
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
		return permissions;
	}
	
	
	public static List<PermissionGroup> getPermissionGroup(Long profileId)
			throws SQLException, Exception, UserNotFoundException {
		Connection conn = null;
		Statement stmt = null;
		List<PermissionGroup> permissionGroups = new ArrayList<PermissionGroup>();
		Boolean hasResult = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(JDBC_DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM sigi.permission_group;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				hasResult = true;
				PermissionGroup permissionGroup = new PermissionGroup();
				permissionGroup.setId(rs.getLong("id"));
				permissionGroup.setName(rs.getString("name"));
				permissionGroup.setEnabled(rs.getBoolean("enabled"));
				permissionGroups.add(permissionGroup);
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
		return permissionGroups;
	}
	
	
	
	
	
}
