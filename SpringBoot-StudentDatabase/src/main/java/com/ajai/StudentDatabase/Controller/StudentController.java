package com.ajai.StudentDatabase.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajai.StudentDatabase.Entity.Student;
import com.ajai.StudentDatabase.Entity.Role;
import com.ajai.StudentDatabase.Entity.User;
import com.ajai.StudentDatabase.Service.StudentService;

@RestController
@RequestMapping("/controller")
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/saveStudent")
	public String saveStudent(@RequestBody Student student) {
		student.setStudent_id(0);
		studentService.save(student);
		return "student " + student.getS_name() + " added to the database";
	}

	@PutMapping("/updateStudent")
	public String updateStudent(@RequestBody Student student) {
		studentService.save(student);
		return "student" + student.getS_name() + "has been updated";
	}

	@GetMapping("/findStudentById/{student_id}")
	public Optional<Student> findStudentById(@PathVariable long student_id) {
//		Optional<Employee> employee = employeeService.findEmployeeById(employee_id);
//
//		if (employee == null) {
//			throw new RuntimeException("Employee with id : " + employee_id + " not found");
//		}
		return studentService.findStudentById(student_id);
	}

	@GetMapping("/findStudentByName/{s_name}")
	public List<Student> findStudentByName(@PathVariable String s_name) {
//		List<Employee> eList = employeeService.findEmployeeByFirstName(firstname);
//
//		if (eList == null) {
//			throw new RuntimeException("Employee with First Name : " + firstname + " not found");
//		}

		return studentService.findStudentByName(s_name);
	}


	@GetMapping("/findAllStudents")
	public List<Student> findAllStudents() {
		return studentService.findAllStudents();
	}

	@DeleteMapping("/deleteStudentById/{student_id}")
	public String deleteStudentById(@PathVariable long student_id) {

		Optional<Student> employee = studentService.findStudentById(student_id);

		if (employee != null) {
			studentService.deleteStudentById(student_id);
			return "Deleted student id - " + student_id;
		} else {
			return "Delete operation failed";
		}

	}

}
