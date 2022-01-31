package com.ajai.StudentDatabase.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student_table")
@Data
public class Student { 
	
//	public Employee () {}
	
	@Id
	@Column(name = "student_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Student_id;
	
	@Column(name = "s_name")
	private String s_name;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "country")
	private String country;
	
	

		
	
}
