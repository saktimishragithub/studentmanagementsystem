package com.demo.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.demo.entity.Student;

public class CustomStudentDetail implements UserDetails {

	private Student student;

	public CustomStudentDetail(Student student) {
		this.student = student;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
	SimpleGrantedAuthority grantedAuthority=	new SimpleGrantedAuthority(student.getRole());
		return List.of(grantedAuthority);
		
	}

	@Override
	public String getPassword() {
		
		return student.getPassword();
	}

	@Override
	public String getUsername() {
		
		return student.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
