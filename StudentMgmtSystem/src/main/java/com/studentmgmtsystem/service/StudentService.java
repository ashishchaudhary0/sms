/**
 * 
 */
package com.studentmgmtsystem.service;

import java.util.List;

import com.studentmgmtsystem.entity.Student;

/**
 * @author hp
 *
 */

public interface StudentService {
	
	public List<Student> getAllStudent();
	
	public Student createStudent(Student student);
	
	public Student updateStudentById(long id);
	
	public void deleteStudentById(long id);

}
