package com.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.entity.Student;
import com.demo.service.IStudentService;
import com.deom.exception.CustomException;

@Controller
public class StudentController {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private IStudentService studentService;
	public StudentController(IStudentService studentService) {
		
		this.studentService = studentService;
	}
	
	public StudentController() {
		
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/")
	public String home() {
		return "students";
	}

	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		student.setPassword(this.bCryptPasswordEncoder.encode(student.getPassword()));
		studentService.saveStudent(student);
				return "redirect:/students";
	}
		
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("student") Student student,
			Model model) {
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setMobNo(student.getMobNo());
		existingStudent.setAge(student.getAge());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setPassword(this.bCryptPasswordEncoder.encode(student.getPassword()));
		existingStudent.setRole(student.getRole());
		studentService.updateStudent(existingStudent);
		System.out.println("hii");
		return "redirect:/students";		
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	
}
