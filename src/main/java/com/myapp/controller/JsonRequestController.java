package com.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.model.Student;
import com.myapp.service.StudentService;

@RestController
public class JsonRequestController {

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {
		System.out.println("fetching User with user id : " + id);
		Student st = studentService.findUserById(id);
		if (st == null) {
			System.out.println("no User exist with id : " + id);
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		System.out.println("Name:" + st.getName());
		return new ResponseEntity<Student>(st, HttpStatus.OK);
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<Student> postStudent(@RequestBody Student student) {
		System.out.println("Inside Post");
		System.out.println("Creating Student  : " + student.getName());
		if (studentService.isUserExist(student)) {
			System.out.println("A User with name " + student.getName()
					+ " already exist");
			return new ResponseEntity<Student>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}


	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Student> putStudent(@PathVariable("id") int id,
			@RequestBody Student student) {
		Student st1 = studentService.updateStudent(id, student);
		System.out.println("Name:" + st1.getName());
		try {
		boolean flag=(st1 != null);
		if (!flag) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		}
		catch (NullPointerException e){
			System.out.println(e);
		}
		return new ResponseEntity<Student>(st1, HttpStatus.OK);
	}

}
