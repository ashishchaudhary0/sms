/**
 * 
 */
package com.studentmgmtsystem.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentmgmtsystem.entity.Student;
import com.studentmgmtsystem.service.StudentService;

import lombok.Delegate;

/**
 * @author hp
 *
 */
//@RestController
@org.springframework.stereotype.Controller
public class StudentController {
	
	private StudentService service;
	
	public StudentController(StudentService service) {
		super();
		this.service = service;
	}

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("name","Ashish");
		return "home";
	}
	
	@GetMapping("students")
	public String allStudentList(Model model) {
		List<Student> students = service.getAllStudent();
		System.out.println("Students: " + students); 
		model.addAttribute("students", students);
		return "students";
		
	}
	
	@GetMapping("/students/new")
	public String createStudent(Model model) {
		
		Student student = new Student();
		model.addAttribute("student", student);
		
		return "create-student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") @RequestBody Student student) {
		service.createStudent(student);
		
		return "redirect:/students";  //we are redirecting it to get all student list method so that it will be added in the list of std and see on screen.
		
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable long id, Model model) {
		
		model.addAttribute("student", service.updateStudentById(id));
		
		return "edit_student";
		
	}
	
	@PostMapping("/students/edit/{id}")
	public String updateStudent(@PathVariable long id, @ModelAttribute("student") Student student) {
		Student existingStudent = service.updateStudentById(id);
		
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		service.createStudent(existingStudent);
		return "redirect:/students";
	
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable long id) {
		service.deleteStudentById(id);
		return "redirect:/students";
	}

}
