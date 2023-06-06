package com.demo.service;

import java.util.List;

import com.demo.entity.Student;

public interface IStudentService  {

	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);

}
