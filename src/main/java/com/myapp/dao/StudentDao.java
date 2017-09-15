package com.myapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.myapp.utility.JdbcDerbyConnection;

@Repository
public class StudentDao {
	private Connection con;
	private Statement stmt;

	public void queryTable() {
		try {
			con=JdbcDerbyConnection.getDbConnection();
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.executeQuery("Create table Student (name varchar(30))");
			//stmt.executeQuery("Create table Student (name varchar(30), rollNo int primary key, varchar(30) address, varchar(30) email)");
			//stmt.executeUpdate("insert into users values ('Tom', 1,'UK', 'tom.com')");
			stmt.executeUpdate("insert into Student values ('Tom')");
			ResultSet rs = stmt.executeQuery("select * from users" );
			while(rs.next()){
				System.out.println(rs.getString("name"));
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JdbcDerbyConnection.closeDbConnection();
		
	}

}
