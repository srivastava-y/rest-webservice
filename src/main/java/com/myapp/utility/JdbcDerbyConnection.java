package com.myapp.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcDerbyConnection {
	static Connection con=null;
	private static String dbURL="jdbc:derby:codejava/webdb1;create=true";
	
	public static Connection getDbConnection() throws SQLException{
		con= DriverManager.getConnection(dbURL);
		if(con!=null){
			System.out.println("DB is connected...");
		}
		return con;
	}
	public static void closeDbConnection(){
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
