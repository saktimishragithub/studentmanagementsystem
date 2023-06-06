package com.deom.exception;

import org.springframework.stereotype.Component;

@Component
public class CustomException extends Exception {
	
	public CustomException() {
		
	}
public CustomException(String msg) {
		super(msg);
	}
	
	

}
