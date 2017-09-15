package com.myapp.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.dao.StudentDao;
import com.myapp.model.Student;
import com.myapp.utility.JdbcDerbyConnection;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;
	String json;
	Student student1 = new Student("Yogi", 12, "Varanasi", "yogi@yogi.com");

	public boolean isUserExist(Student student) {
		if (student.getName().equals(student1.getName()))
			return true;
		return false;

	}

	public Student findUserById(int id) {
		studentDao.queryTable();
		
		System.out.println(" getting student rollno in my service class : "
				+ student1.getRollNo());
		if (id == student1.getRollNo()) {
			System.out.println("in service truwe");
			return student1;
		}
		return null;
	}

	public Student updateStudent(int id, Student student) {
		if(id==student1.getRollNo()){
			student1 =student;
			System.out.println("after updating in service method we got roll no : " + student1.getRollNo());
			System.out.println("after updating in service method we got name : " + student1.getName());
			System.out.println("after updating in service method we got Address : " + student1.getAddress());
			System.out.println("after updating in service method we got Email : " + student1.getEmail());
			return student1;
		}
		return null;
	}
	
	public void checkConnection(){
		try {
			JdbcDerbyConnection.getDbConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("now closing the connection.....");
		JdbcDerbyConnection.closeDbConnection();
	}
	

}
