package com.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.demo.entity.Student;
import com.demo.repositary.StudentRepositary;

@Component
public class StudentDetailServiceImpl  implements UserDetailsService{
	
	@Autowired
	private StudentRepositary repositary;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Student student=repositary.findByEmail(username);
		if(student==null) {
			throw new UsernameNotFoundException("Invalid Email !!");
		}
		CustomStudentDetail customStudentDetail =new CustomStudentDetail(student);
		return customStudentDetail;
	}

}
