package com.kshitij.patient.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	

	private static final String DRIVER_NAME="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3307/";
	private static final String DB_NAME="patient_db";
	private static final String USER_NAME="root";
	private static final String PASSWORD="admin";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_NAME);
		return DriverManager.getConnection(URL+DB_NAME,USER_NAME,PASSWORD);

}
}
