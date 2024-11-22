/**
 * 
 */
package com.studentmgmtsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentmgmtsystem.entity.Student;

/**
 * @author hp
 *
 */
public interface StudentRepository extends JpaRepository<Student, Long>{ 

}
