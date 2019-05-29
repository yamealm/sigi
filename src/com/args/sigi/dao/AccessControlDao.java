package com.args.sigi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.args.sigi.exception.EmptyListException;
import com.args.sigi.exception.GeneralException;
import com.args.sigi.exception.NullParameterException;
import com.args.sigi.exception.RegisterNotFoundException;
import com.args.sigi.exception.UserNotFoundException;
import com.args.sigi.generic.dao.GenericDao;
import com.args.sigi.object.Permission;
import com.args.sigi.object.PermissionData;
import com.args.sigi.object.PermissionGroup;
import com.args.sigi.object.PermissionHasProfile;
import com.args.sigi.object.Profile;
import com.args.sigi.object.ProfileData;
import com.args.sigi.object.User;
import com.args.sigi.util.EJBRequest;
import com.args.sigi.util.QueryConstants;

public class AccessControlDao extends GenericDao {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/sigi";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";// cambio tu clave gordo y modifique tu
										// driver de mysql en tu braund

	public void deletePermissionHasProfile(Long profileId) throws NullParameterException, GeneralException {
		Connection conn = null;
		Statement stmt = null;
		User user = new User();
		Boolean hasResult = false;
		if (profileId == null) {
			throw new NullParameterException("Invalid profileId");
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "DELETE FROM permission_has_profile WHERE profileId=" + profileId;
			stmt.executeQuery(sql);
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new GeneralException("Error General", e);
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}

	public List<Profile> getParentsByProfile(EJBRequest request)
			throws EmptyListException, GeneralException, NullParameterException {
		List<Profile> profiles = new ArrayList<Profile>();
		List<PermissionHasProfile> permissionHasProfiles = new ArrayList<PermissionHasProfile>();
		List<ProfileData> profileDatas = new ArrayList<ProfileData>();
		Connection conn = null;
		Statement stmt = null;
		Map<String, Object> params = request.getParams();
		if (!params.containsKey(QueryConstants.PARAM_PROFILE_ID)) {
			throw new NullParameterException("Invalid Parameter " + QueryConstants.PARAM_PROFILE_ID);
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT php.parent FROM permission_has_profile php WHERE php.childId = "
					+ params.get(QueryConstants.PARAM_PROFILE_ID) + " AND php.endingDate IS NULL";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Profile profile = new Profile();
				profile.setId(rs.getLong("id"));
				profile.setName(rs.getString("name"));
				profile.setEnabled(Boolean.parseBoolean(rs.getString("enabled")));
				PermissionHasProfile php = new PermissionHasProfile();
				permissionHasProfiles.add(php);
				profile.setPermissionHasProfiles(permissionHasProfiles);
				ProfileData profileData = new ProfileData();
				profileDatas.add(profileData);
				profile.setProfileData(profileDatas);
				profiles.add(profile);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new GeneralException("Error General", e);
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		if (profiles.isEmpty()) {
			throw new EmptyListException("Profile not found");
		}
		return profiles;
	}

	public List<Permission> getPermissions(EJBRequest request)throws EmptyListException, GeneralException, NullParameterException {
		List<Permission> permissions = new ArrayList<Permission>();
		List<PermissionData> permissionDatas = new ArrayList<PermissionData>();
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM permission p WHERE p.enabled = TRUE";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Permission permission = new Permission();
				permission.setId(rs.getLong("id"));
				permission.setName(rs.getString("name"));
				permission.setEnabled(Boolean.parseBoolean(rs.getString("enabled")));
				permission.setEntity(rs.getString("entity"));
				PermissionData data = new PermissionData();
				permissionDatas.add(data);
				permission.setPermissionData(permissionDatas);
				PermissionGroup permissionGroup = new PermissionGroup();
				permission.setPermissionGroup(permissionGroup);
				permissions.add(permission);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new GeneralException("Error General", e);
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		if (permissions.isEmpty()) {
			throw new EmptyListException("Permissions not found");
		}
		return permissions;
	}

	public List<Profile> getProfiles(EJBRequest request)
			throws EmptyListException, GeneralException, NullParameterException {
		List<Profile> profiles = new ArrayList<Profile>();
		List<PermissionHasProfile> permissionHasProfiles = new ArrayList<PermissionHasProfile>();
		List<ProfileData> profileDatas = new ArrayList<ProfileData>();
		Connection conn = null;
		Statement stmt = null;
		Map<String, Object> params = request.getParams();
		if (!params.containsKey(QueryConstants.PARAM_PROFILE_ID)) {
			throw new NullParameterException("Invalid Parameter " + QueryConstants.PARAM_PROFILE_ID);
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM profile p WHERE p.enabled = TRUE";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Profile profile = new Profile();
				profile.setId(rs.getLong("id"));
				profile.setName(rs.getString("name"));
				profile.setEnabled(Boolean.parseBoolean(rs.getString("enabled")));
				PermissionHasProfile php = new PermissionHasProfile();
				permissionHasProfiles.add(php);
				profile.setPermissionHasProfiles(permissionHasProfiles);
				ProfileData profileData = new ProfileData();
				profileDatas.add(profileData);
				profile.setProfileData(profileDatas);
				profiles.add(profile);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new GeneralException("Error General", e);
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		if (profiles.isEmpty()) {
			throw new EmptyListException("Profile not found");
		}
		return profiles;
	}

	public Permission loadPermission(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException {
		Connection conn = null;
		Statement stmt = null;
		Boolean hasResult = false;
		Permission permission = new Permission();
		List<PermissionData> permissionDatas = new ArrayList<PermissionData>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM permission p WHERE p.enabled = TRUE";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				hasResult = true;
				permission.setId(rs.getLong("id"));
				permission.setName(rs.getString("name"));
				permission.setEnabled(Boolean.parseBoolean(rs.getString("enabled")));
				permission.setEntity(rs.getString("entity"));
				PermissionData data = new PermissionData();
				permissionDatas.add(data);
				permission.setPermissionData(permissionDatas);
				PermissionGroup permissionGroup = new PermissionGroup();
				permission.setPermissionGroup(permissionGroup);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new GeneralException("Error General", e);
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		if (!hasResult) {
			throw new RegisterNotFoundException("Permissions not found");
		}

		return permission;
	}

	public Profile loadProfile(EJBRequest request)throws RegisterNotFoundException, NullParameterException, GeneralException {
		Profile profile = new Profile();
		List<PermissionHasProfile> permissionHasProfiles = new ArrayList<PermissionHasProfile>();
		List<ProfileData> profileDatas = new ArrayList<ProfileData>();
		Connection conn = null;
		Statement stmt = null;
		Map<String, Object> params = request.getParams();
		if (!params.containsKey(QueryConstants.PARAM_PROFILE_ID)) {
			throw new NullParameterException("Invalid Parameter " + QueryConstants.PARAM_PROFILE_ID);
		}
		Boolean hasResult = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM profile p WHERE p.id=" + params.get(QueryConstants.PARAM_PROFILE_ID) + " p.enabled = TRUE";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				profile.setId(rs.getLong("id"));
				profile.setName(rs.getString("name"));
				profile.setEnabled(Boolean.parseBoolean(rs.getString("enabled")));
				PermissionHasProfile php = new PermissionHasProfile();
				permissionHasProfiles.add(php);
				profile.setPermissionHasProfiles(permissionHasProfiles);
				ProfileData profileData = new ProfileData();
				profileDatas.add(profileData);
				profile.setProfileData(profileDatas);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new GeneralException("Error General", e);
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		if (!hasResult) {
			throw new RegisterNotFoundException("Profile not found");
		}
		return profile;
	}
//
//	public Permission savePermission(EJBRequest request) throws NullParameterException, GeneralException {
//		return (Permission) saveEntity(request, logger, getMethodName());
//	}
//
//	public Profile saveProfile(EJBRequest request) throws NullParameterException, GeneralException {
//		return (Profile) saveEntity(request, logger, getMethodName());
//	}
//
//	public ProfileData saveProfileData(EJBRequest request) throws NullParameterException, GeneralException {
//		return (ProfileData) saveEntity(request, logger, getMethodName());
//
//	}
//
//	public User validateUser(String login, String password)
//			throws RegisterNotFoundException, NullParameterException, GeneralException, DisabledDistributorException {
//		User user = null;
//
//		if (login == null || login.equals("")) {
//			throw new NullParameterException(sysError.format(EjbConstants.ERR_NULL_PARAMETER, this.getClass(),
//					getMethodName(), QueryConstants.PARAM_LOGIN), null);
//		}
//		if (password == null || password.equals("")) {
//			throw new NullParameterException(sysError.format(EjbConstants.ERR_NULL_PARAMETER, this.getClass(),
//					getMethodName(), QueryConstants.PARAM_PASSWORD), null);
//		}
//
//		try {
//			user = userEJB.loadUserByLogin(login);
//			if (user != null && !user.getPassword().equals(password)) {
//				user = null;
//				throw new RegisterNotFoundException(logger, sysError.format(EjbConstants.ERR_EMPTY_LIST_EXCEPTION,
//						this.getClass(), getMethodName(), "user"), null);
//			}
//
//		} catch (NoResultException ex) {
//			throw new RegisterNotFoundException(logger,
//					sysError.format(EjbConstants.ERR_EMPTY_LIST_EXCEPTION, this.getClass(), getMethodName(), "user"),
//					ex);
//		} catch (RegisterNotFoundException ex) {
//			throw new RegisterNotFoundException(logger,
//					sysError.format(EjbConstants.ERR_EMPTY_LIST_EXCEPTION, this.getClass(), getMethodName(), "user"),
//					ex);
//		} catch (Exception ex) {
//			throw new GeneralException(logger,
//					sysError.format(EjbConstants.ERR_EMPTY_LIST_EXCEPTION, this.getClass(), getMethodName(), "user"),
//					ex);
//		}
//		if (!user.getEnabled()) {
//			throw new DisabledDistributorException(logger, sysError.format(EjbConstants.ERR_EMPTY_LIST_EXCEPTION,
//					this.getClass(), getMethodName(), "distributor enabled"), null);
//		}
//
//		return user;
//	}

}
