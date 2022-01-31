package com.ajai.StudentDatabase.Service;

import java.util.List;
import java.util.Optional;

import com.ajai.StudentDatabase.Entity.Student;
import com.ajai.StudentDatabase.Entity.Role;
import com.ajai.StudentDatabase.Entity.User;

public interface StudentService {
	
	public List<Student> findAllStudents();
	
	public Optional<Student> findStudentById(long student_id);
	
	public List<Student> findStudentByName(String s_name); 
	
	public void save(Student student);
	
	public void deleteStudentById(long student_id);
	 
 
}
