package com.myapp.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcDerbyConnection {
	static Connection con=null;
	//jdbc:derby://localhost:1527/derbydb;create=true
	//jdbc:derby://localhost:1527//D:/derby/dbname;create=true
	//private static String dbURL="jdbc:derby:codejava/webdb1;create=true";
	private static String dbURL="jdbc:derby:derbydb/mydb1;create=true";
	public static Connection getDbConnection() throws SQLException{
		//Class.forName("org.apache.derby.jdbc.ClientDriver");
		DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
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
