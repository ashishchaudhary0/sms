/**
 * 
 */
package com.studentmgmtsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentmgmtsystem.entity.Student;
import com.studentmgmtsystem.repository.StudentRepository;

/**
 * @author hp
 *
 */
@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository studentRepo;

	public StudentServiceImpl(StudentRepository studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}

	@Override
	public List<Student> getAllStudent() {
		
		return studentRepo.findAll(); 
	}

	@Override
	public Student createStudent(Student student) {
		return studentRepo.save(student);
		
	}

	@Override
	public Student updateStudentById(long id) {
		return studentRepo.findById(id).get();
	}

	@Override
	public void deleteStudentById(long id) {
		   studentRepo.deleteById(id);
	} 

}
