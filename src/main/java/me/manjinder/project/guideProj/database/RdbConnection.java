package me.manjinder.project.guideProj.database;

import java.sql.Connection;
import java.sql.DriverManager;



// @ Manjinder Singh - manjindersingh.me
public class RdbConnection{
	private static Connection conn=null;
	
	public static Connection createConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		try {
			conn = DriverManager.getConnection(ConfigData.JDBC_URL,ConfigData.JDBC_USER,ConfigData.JDBC_PASS);
		}catch(Exception e) {
			throw e;
		}
		return conn;
	}
}
