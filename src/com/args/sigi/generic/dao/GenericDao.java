package com.args.sigi.generic.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.args.sigi.dao.util.UtilDao;

public class GenericDao extends UtilDao {

	public static PreparedStatement getStatement(String sql){
		try {
			Connection connObj = null;
			connObj = DriverManager.getConnection(JDBC_DB_URL, JDBC_USER, JDBC_PASS);
			Class.forName(JDBC_DRIVER);
			return connObj.prepareStatement(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;  
	}
}
