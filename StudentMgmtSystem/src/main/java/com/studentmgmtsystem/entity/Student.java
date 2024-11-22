/**
 * 
 */
package com.studentmgmtsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * @author hp
 *
 */
@Entity
@Data
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;
	private String firstName;
	private String lastName;
	private String email;

}
