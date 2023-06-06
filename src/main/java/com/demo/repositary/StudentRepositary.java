package com.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entity.Student;

@Repository
public interface StudentRepositary extends JpaRepository<Student, Long> {
	
	public Student findByEmail(  String email);

}
