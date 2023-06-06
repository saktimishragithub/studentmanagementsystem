package com.deom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MyExceptionHandler {
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value=NullPointerException.class)
	public  String ExceptionHandelarBYNull( Model m) {
		m.addAttribute("msg" ,"Null Pointer Exception");
		return "error";
	}
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value=NumberFormatException.class)
	public  String ExceptionByWorngUrl(Model m) {
		m.addAttribute("msg" ,"Nuber Format Exception");
		return "error";
	}
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=Exception.class)
	public  String GenerisedException(Model m) {
		m.addAttribute("msg" ," Unknown Exception");
				return "error";
	}


}
